//Desktop_Drawer
//loginController.java v3
//This controller handles all functions and calls related to login
//Zachary Robbins And Tay Rosby
//11/3/2019
package com.gcu.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.DatabaseException;
import com.gcu.business.UserBusinessInterface;
import com.gcu.model.Credentials;
import com.gcu.model.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	UserBusinessInterface service;
	
	/**
	 * injects an implemented instance of UserBusinessInterface
	 * @param service - an instance of the UserBusinessInterface
	 */
	@Autowired
	public void setUserService(UserBusinessInterface service) {
		this.service = service;
	}
	
	/**
	 * temporary navigation function to the login form
	 * @return - returns a ModelAndView with an empty credentials model and the login page as the view destination
	 */
	@RequestMapping(path = "/loginUser", method = RequestMethod.GET)
	public ModelAndView getUserCredentials()  
	{
		logger.info("Entering LoginController.getUserCredentials");
		logger.info("Exiting LoginController.getUserCredentials");
		return new ModelAndView("login", "credentials", new Credentials());
	}
	
	/**
	 * grabs the users login information and logs them in. Currently does not check for information against a database since one has not been implemented.
	 * @param credentials - the users login information
	 * @param result - Data Validation informtion
	 * @return returns a modelandview consisting of either the filled credentials model and the login view or the filed credentials model and the Homepage
	 */
	@RequestMapping(path = "/displayLogin", method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid@ModelAttribute("credentials")Credentials credentials, BindingResult result) 
	{
		logger.info("Entering LoginController.loginUser");
		try {
		if(result.hasErrors() == true)
		{
			logger.info("Exiting LoginController.loginUser w fail");
			return new ModelAndView("login", "credentials", credentials);
		}else {
			//login user to database, Data Service will return a model and view based on the result
			ModelAndView mv = service.login(credentials);
			//System.out.println("Test");
			logger.info("Exiting LoginController.loginUser w pass");
			return mv;
		}
		}
		catch(Exception e) {
			logger.error("LoginController.loginUser has failed with ", e);
			//throw new DatabaseException("There is an error in the database");
			return new ModelAndView("exception");
		}
	}
	
	/**
	 * takes the user to the main page from login
	 * @param model -  a  ModelMap object that will be given a message for an attribute 
	 * @return returns the main view navigation and model with a message attribute
	 */
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String printHello(ModelMap model) 
	{
		logger.info("Entering LoginController.printHello");
		//return a model with an attribute named message
		//return a View named hello passed in ModelMap
		model.addAttribute("message", "Welcome to Desktop Drawer!");
		logger.info("Exiting LoginController.printHello");
		return "main";
	}

	
}
