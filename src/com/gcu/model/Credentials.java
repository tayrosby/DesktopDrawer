//Desktop_Drawer
//Credentials.java v1
//This object model is used to log in the user
//Zachary Robbins And Tay Rosby
//9/20/2019
package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Credentials {
	
	@NotNull(message="The Email can not be null")
	@Size(min=2, max=30, message="The Email must be between 2 and 30 characters")
	/**
	 * a string object to hold a users login email
	 */
	private String email;
	
	@NotNull(message="The Password can not be null")
	@Size(min=2, max=30, message="The Password must be between 2 and 30 characters")
	/**
	 * a string object to hold a users password
	 */
	private String password;
	
	//Default Constructor
	public Credentials()
	{
		this.email = "";
		this.password = "";
	}

	//Non-Default Constructor
	public Credentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	//the getters and setters are used to set and retrieve information for the users login information
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}