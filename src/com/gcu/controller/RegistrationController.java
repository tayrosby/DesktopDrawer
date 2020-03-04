//Desktop_Drawer
//registrationController.java v2
//This controller handles all functions and calls related to registration
//Zachary Robbins And Tay Rosby
//10/10/2019/
package com.gcu.controller;

import javax.validation.Valid;

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
import com.gcu.model.User;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	UserBusinessInterface service;
	
	/**
	 * Injection of an implemented instance of the UserBusinessInterface
	 * @param service - an instance of UserBusinessInterface
	 */
	@Autowired
	public void setUserService(UserBusinessInterface service) {
		this.service = service;
	}
	
	/**
	 * takes the user to the registration form
	 * @return - returns a modelandview consisting of an empty instance of a user model and the registration page view
	 */
	@RequestMapping(path="/goToRegister", method = RequestMethod.GET)
	public ModelAndView goToRegister()
	{
		return new ModelAndView("register", "user", new User());
	}
	
	/**
	 * takes the users submitted information and places it into a user model and sends it to a view to display the information
	 * @param user - the users information in a model
	 * @param result - data validation information
	 * @return - returns a model and view consisting of either a filled user model and the register page view or a filled user model with the displayRegister view
	 */
	@RequestMapping(path="/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid@ModelAttribute("user")User user, BindingResult result)
	{
		try {
		if(result.hasErrors() == true) {
			return new ModelAndView("register", "user", user);
		}else {
			if(service.check(user) == true)
			{
				return new ModelAndView("register", "user", user);
			}else {
			
			//register user to database
			service.register(user);
			return new ModelAndView("redirect:/login/loginUser");
			//return new ModelAndView("displayRegister", "user", user);
			}
		}
		}
		catch(Exception e) {
			//throw new DatabaseException("There is an error in the database");
			return new ModelAndView("exception");
		}
	}
	
	/**
	 * takes the user to the dashboard page
	 * @param model - contains a message attribute
	 * @return - returns the main pages name for navigation
	 */
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String printHello(ModelMap model) 
	{
		//return a model with an attribute named message
		//return a View named hello passed in ModelMap
		model.addAttribute("message", "Welcome to Desktop Drawer!");
		return "main";
	}
}