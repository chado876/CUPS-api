package com.cups.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cups.api.entities.AuthToken;
import com.cups.api.entities.Customer;
import com.cups.api.exceptions.ResourceNotFoundException;
import com.cups.api.services.CustomerAuthService;
import com.cups.api.viewmodels.CustomerLoginViewModel;
import com.cups.api.viewmodels.LoginViewModel;
import com.cups.api.viewmodels.ResponseResult;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	protected CustomerAuthService authService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from the other side -8-";
	}
	
	@GetMapping("/manager/{managerid}")
	public LoginViewModel getManager(
			@PathVariable("managerid") String managerid) {
		LoginViewModel data = new LoginViewModel(managerid,"never send passowrd");
		return data;
	}
	
	@PostMapping("/login")
	public String login(
			@RequestBody LoginViewModel credentials
			) {
		return String.format("Fake-Token-%s-%s", credentials.getManagerid(),
				credentials.getPassword());
		}
	@PostMapping("/customerlogin")
	public ResponseResult<AuthToken> customerLogin(
			@RequestBody CustomerLoginViewModel credentials
			) {
		System.out.println("DEBUG : "+credentials);
		    AuthToken data = authService.login(
		    		credentials.getFirstName(), 
                   credentials.getLastName(), 
                   credentials.getDigitalIdType(),
                   credentials.getDigitalId()
                   );
		    data.getCustomer().setTokens(null);
		    ResponseResult<AuthToken> response = new ResponseResult<AuthToken>(
		    		data != null, data
		    		);
		    return response;
		}
	
	@GetMapping("/getuserdetails")
	public Customer whoami(
			@RequestHeader("Authorization")
			String authorizationHeader
		) {
		System.out.println("DEBUG: Received authorization header - "+authorizationHeader);
		String token = CustomerAuthService.extractTokenFromAuthorizationHeader(authorizationHeader);
		Customer customer = authService.getUserFromToken(token);
		
		if(customer != null) {
			customer.setTokens(tokens);
			return customer;
		}
		throw new ResourceNotFoundException("Customer", "token", token);
	}
}
