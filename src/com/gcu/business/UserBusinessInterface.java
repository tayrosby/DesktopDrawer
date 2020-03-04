//Desktop_Drawer
//UserBusinessInterface.java v2
//This controller handles all functions and calls related to registration
//Zachary Robbins And Tay Rosby
//11/10/2019
package com.gcu.business;

import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.Credentials;
import com.gcu.model.User;

public interface UserBusinessInterface {

	/**
	 * take the credentials inputted by the user and check to see if they have an existing account
	 * @param credentials - Username and password of user
	 * @return either the dashboard or the login page
	 */
	public ModelAndView login(Credentials credentials);	
	
	/**
	 * take the inputted user information and place it into the database as an account
	 * @param user - the person registering
	 */
	public void register(User user);
	
	/**
	 * takes the email passed through a user model and checks the dataservice to see if an account already exists in the batabase
	 * @param user - the person registering
	 * @return true or false depending on if a user is found
	 **/
	public boolean check(User user);
}