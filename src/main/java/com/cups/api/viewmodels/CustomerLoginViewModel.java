package com.cups.api.viewmodels;

public class CustomerLoginViewModel {
    private String firstName,
                   lastName,
                   digitalIdType,
                   digitalId;

	public CustomerLoginViewModel() {
		super();
	}

	public CustomerLoginViewModel(String firstName, String lastName, String digitalIdType, String digitalId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.digitalIdType = digitalIdType;
		this.digitalId = digitalId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDigitalIdType() {
		return digitalIdType;
	}

	public void setDigitalIdType(String digitalIdType) {
		this.digitalIdType = digitalIdType;
	}

	public String getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(String digitalId) {
		this.digitalId = digitalId;
	}

	@Override
	public String toString() {
		return "CustomerLoginViewModel [firstName=" + firstName + ", lastName=" + lastName + ", digitalIdType="
				+ digitalIdType + ", digitalId=" + digitalId + "]";
	}
   
	
	
}
