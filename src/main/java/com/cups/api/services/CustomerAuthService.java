package com.cups.api.services;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import com.cups.api.entities.AuthToken;
import com.cups.api.entities.Customer;
import com.cups.api.repositories.IAuthTokenRepository;
import com.cups.api.repositories.ICustomerRepository;

@Component
public class CustomerAuthService {
	public static String extractTokenFromAuthorizationHeader(String authorizationHeader) {
		if(authorizationHeader != null) {
			return authorizationHeader.replace("Bearer ","").trim();
		}
		return "";
	}
	@Autowired
	protected IAuthTokenRepository tokenRepo;
	
	@Autowired
	protected ICustomerRepository customerRepo;
	/*
	 * Algorithm:
	//login
	   Query database if username and password exists
	   if user exists
	      generate a new token
	      return token and user
	   otherwise 
	*/

	/**
	 * @return Customer|null - returns Customer details if sucessful
	 * */
	public AuthToken login(
			String firstName, 
			String lastName, 
			String digitalIdType,
			String digitalId) {
		
		Customer sampleCustomerData = new Customer();
		sampleCustomerData.setFname(firstName);
		sampleCustomerData.setLname(lastName);
		
		switch(digitalIdType) {
		case "password":sampleCustomerData.setD_id(digitalId);
		break;
		case "audio":sampleCustomerData.setRecording(digitalId);
		break;
		case "image":sampleCustomerData.setImage(digitalId);
		break;
		}
		System.out.println("DEBUG : Created Customer Copy - "+sampleCustomerData);
		Example<Customer> queryExample = 
				Example.of(
						sampleCustomerData,
						ExampleMatcher.matchingAny()
						              .withIgnoreNullValues()
						              .withIgnorePaths("id","balance")
						   );
		
		
		List<Customer> queryResult = customerRepo.findAll(queryExample);
		if(queryResult.size() > 0) {
			//create a token
			Customer customer = queryResult.get(0);
			return createTokenForCustomer(customer);
		}
		return null;
	}
	
	protected AuthToken createTokenForCustomer(Customer customer) {
		AuthToken token = new AuthToken();
		token.setCustomer(customer);
		token.setToken(generateToken());
		token = tokenRepo.save(token);
		return token;
	}
	
	public boolean isValidToken(String token) {
		AuthToken sampleToken = new AuthToken();
		sampleToken.setToken(token);
		Optional<AuthToken> queryResult = tokenRepo.findOne(
				Example.of(sampleToken,
						ExampleMatcher.matchingAny()
			              .withIgnoreNullValues()
			              .withIgnorePaths("id","validUntil"))
			);
		//option 1 have the database query select all tokens that match the token value
		//         and valid until date is within 5 hours
		//  select * from authtoken where token= ? and validUntil < now() + ___
		//option 2: do the check in memory whether it exceeds the validation time
		return queryResult.isPresent();
	}
	
	public Customer getUserFromToken(String token) {
		AuthToken sampleToken = new AuthToken();
		sampleToken.setToken(token);
		Optional<AuthToken> queryResult = tokenRepo.findOne(
				Example.of(sampleToken,
						ExampleMatcher.matchingAny()
			              .withIgnoreNullValues()
			              .withIgnorePaths("id","validUntil")
			              )
				);
		
		if(queryResult.isPresent()) {
			return queryResult.get().getCustomer();
		}
		return null;
	}
	
	/*
	 * JWT Standard*/
	public String generateToken() {
		final char[] alphabet="abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		String randomStr="";
		Random r=new Random();
		for(int i=0;i<12;i++) {
			randomStr+=
					alphabet[r.nextInt(alphabet.length-1)];
		}
		return randomStr;
	}

}
