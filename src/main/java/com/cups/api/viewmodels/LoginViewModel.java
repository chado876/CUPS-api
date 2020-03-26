package com.cups.api.viewmodels;

public class LoginViewModel {

	private String managerid;
	private String password;
	
	
	
	public LoginViewModel() {
		super();
	}
	public LoginViewModel(String managerid, String password) {
		super();
		this.managerid = managerid;
		this.password = password;
	}
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
