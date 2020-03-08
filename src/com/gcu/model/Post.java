//Desktop_Drawer
//Posts.java v1
//This object model is used to transfer specific user data throughout the application
//Zachary Robbins And Tay Rosby
//10/07/2019

package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Post {
	
	/**
	 * a int object to hold the users id from the database
	 */
	private int userID;
	
	/**
	 * an int object to hold the post id from the database
	 */
	private int ID;
	
	@NotNull(message="The title cannot be empty")
	@Size(min=2, max=30, message="The Title must be between 2 and 30 characters")
	/**
	 * a string object to hold the title of the post
	 */
	private String title;
	
	@NotNull(message="The content cannot be empty")
	@Size(min=2, max=30, message="The Content section must be between 2 and 30 characters")
	/**
	 * a string object to hold the content of the post
	 */
	private String content;
	
	//Default Constructor
	public Post()
	{
		this.userID = 1;
		this.ID = 0;
		this.title = "";
		this.content = "";
	}

	//Non-Default Constructor
	public Post(int userID, int ID, String title, String content) {
		super();
		this.userID = userID;
		this.ID = ID;
		this.title = title;
		this.content = content;
	}

	//the getters and setters are used to set and retrieve information for the post information
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	

}
