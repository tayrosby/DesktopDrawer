//Desktop_Drawer
//User.java v1
//This object model is used to transfer specific user data throughout the application
//Zachary Robbins And Tay Rosby
//9/20/2019
package com.gcu.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	/**
	 * an int object to hold the users id from the database
	 */
	private int id;
	
	@NotNull(message="The First Name cannot be null")
	@Size(min=2, max=30, message="The First Name must be between 2 and 30 characters")
	
	/**
	 * a string object to hold the users firstname
	 */
	private String firstName;
	
	@NotNull(message="The Last Name cannot be null")
	@Size(min=2, max=30, message="The Last Name must be between 2 and 30 characters")
	
	/**
	 * a string object to hold the users lastname
	 */
	private String lastName;
	
	@NotNull(message="The Username cannot be null")
	@Size(min=2, max=30, message="The Username must be between 3 and 30 characters")
	
	/**
	 * a string object to hold the users username
	 */
	private String username;
	
	@NotNull(message="The Phonenumber cannot be null")
	@Size(min=10, max=10, message="The Phonenumber must be 10 characters")
	
	/**
	 * a string object with a required 10 characters to hold the users phonenumber
	 */
	private String phonenumber;
	
	@Valid
	
	/**
	 * an instance of the credentials model to hold the users email and password
	 */
	private Credentials credentials;
	
	//Default Constructor
	public User() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.credentials = new Credentials();
		this.phonenumber = "";
	}
	
	//Non-Default Constructor
	public User(int id, String firstName, String lastName, String username, Credentials credentials, String phonenumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.credentials = credentials;
		this.phonenumber = phonenumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}