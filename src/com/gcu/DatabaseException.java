//Desktop_Drawer
//DatabaseException.java v2
//Holds a message to be passed up to the controller to post on the common exception page
//Zachary Robbins And Tay Rosby
//12/13/2019

package com.gcu;

@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException {


	/**
	 * sends a message to the page that calls it
	 * @param message - what is written to
	 */
	public DatabaseException(String message) {
		super(message);
	}
}