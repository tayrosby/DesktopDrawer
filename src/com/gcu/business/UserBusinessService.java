//Desktop_Drawer
//UserBusinessService.java v2
//This is business service for all user data
//Zachary Robbins And Tay Rosby
//11/3/2019
package com.gcu.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.controller.PostController;
import com.gcu.data.DataAccessInterface;
import com.gcu.model.Credentials;
import com.gcu.model.User;

public class UserBusinessService implements UserBusinessInterface {

	@Autowired
	DataAccessInterface<User> service;
	
	PostController pc;

	Logger logger = LoggerFactory.getLogger(UserBusinessService.class);
	
	/**
	 * connects to the database and searches for a user based on the passed credentials, then sends a model and view based on the result
	 * @param credentials - a full credentials model used to search the database for the passed information
	 * @return - returns a ModelAndView based on the result of the if/else statement
	 */
	
	@Override
	public ModelAndView login(Credentials credentials) {
		logger.info("Entering UserBusinessService.login");
		//Logging
	//	System.out.println("Inside of login() in UserBusinessService with credentials---\nEmail:" + credentials.getEmail() + "\nPassword:" + credentials.getPassword());
		//User model to pass to the dataService
		User pass = new User(0,"","", "", credentials,"");
		
		//Empty user model that catches the returned user from the data service
		User user = service.findBy(pass);
		//Logging
//		System.out.println("Retrieved user information:\n" + user.getFirstName() + "\n" +
//															 user.getLastName() + "\n" +
//															 user.getUsername() + "\n" +
//															 user.getCredentials().getEmail() + "\n" +
//															 user.getCredentials().getPassword() + "\n" + 
//															 user.getPhonenumber());
		//checks the returned user model, if the firstname is set then the users information was correctly found, returning the main view
		//if firstname is not set, login failed, returning the login view
		if(user.getFirstName() != "") {
			logger.info("Exiting UserBusinessService.login w pass");
			return new ModelAndView("redirect:/create/dashboard");
			//return new ModelAndView("main", "user", user);
			} else {
			logger.info("Exiting UserBusinessService.login w fail");				
			return new ModelAndView("login", "credentials", credentials);
			}
	}

	/**
	 * There will be future communication logic to the DAO related to registration
	 * @param user - a filled user model, this data will be put into the database
	 */
	@Override
	public void register(User user) {
		logger.info("Entering UserBusinessService.register");
		//System.out.println("Inside of register() in UserBusinessService with User---\nName:" + user.getFirstName());	
		
		//calls the create method from the data access interface
		service.create(user);
		logger.info("Exiting UserBusinessService.register");
	}
	
	/**
	 * checks to make a user is returned from the data service, if a user is passed a true is returned, if not a false is returned
	 * @param user - a full user model, this information will be searched for in the database
	 * @return - returns a boolean true/false to let the business service know if a users information is currently in the database
	 */
	@Override
	public boolean check(User user) {
		logger.info("Entering UserBusinessService.check");
		//checks if the user exists in the database
		if(service.check(user) >= 1) {
			logger.info("Exiting UserBusinessService.check w true");
			return true;
			//returns false if no user is found
		} else {
			logger.info("Exiting UserBusinessService.check w false");
			return false;
		}
	}

}
