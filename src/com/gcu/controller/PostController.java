//Desktop_Drawer
//PostController.java v2
//This controller handles all functions and calls related to crud functions a post
//Zachary Robbins And Tay Rosby
//11/10/2019

package com.gcu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.DatabaseException;
import com.gcu.business.PostBusinessInterface;
import com.gcu.model.Post;

@Controller
@RequestMapping("/create")
public class PostController {

	PostBusinessInterface service;

	Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	/**
	 * navigates to the addPost view
	 * @return model with the addPost view
	 */
	public ModelAndView displayForm() 
	{
		logger.info("Entering PostController.displayForm");
		logger.info("Exiting PostController.displayForm");
		return new ModelAndView("addPost", "post", new Post());
	}
	
	@RequestMapping(path = "/addPost", method = RequestMethod.POST)
	/**
	 * adds a post
	 * @param post instance of the post model
	 * @param result results from the data validation
	 * @return either a model with the addPost view, or a list of posts with the displayPosts view
	 */
	public ModelAndView addPost(@Valid @ModelAttribute("post")Post post, BindingResult result) 
	{
		logger.info("Entering PostController.addPost");
		try {
		//validate the model
		if(result.hasErrors()) 
		{
			logger.info("Exiting PostController.addPost w fail");
			return new ModelAndView("addPost", "post", post);
		}
		
		
		//calls orders business service
		service.addPost(post);
		
		logger.info("Exiting PostController.addPost w pass");

		//display a list of posts
		return new ModelAndView("displayPosts", "posts", service.getListOfPosts());
		
		}
		catch(Exception e) {
			logger.error("PostController.addPost has failed with ", e);
			//throw new DatabaseException("There is an error in the database");
			return new ModelAndView("exception");
		}
		
	}
	
	/**
	 * navigates to the deletePost URI
	 * @param post - the post object being deleted
	 * @return a model with the displayPosts view
	 */
	@RequestMapping(path = "/deletePost", method = RequestMethod.POST)
	public ModelAndView deletePost(@ModelAttribute("post")Post post) 
	{
		logger.info("Entering PostController.deletePost");
		try {
		//calls the business service
		service.deletePost(post);
		
		//saves the contacts retrieved from the database to a list
		List<Post> posts = service.getListOfPosts();
		
		logger.info("Exiting PostController.deletePost");

		//returns the list with the displayContacts view
		return new ModelAndView("displayPosts", "posts", posts);
		

		}
		catch(Exception e) {
			logger.error("PostController.deletePost has failed with ", e);
			//throw new DatabaseException("There is an error in the database");
			return new ModelAndView("exception");
		}
	}

	/**
	 * returns a ModelAndView going to the edit post form
	 * @param post - the post that is going to be editted
	 * @return - a ModelAndView going to the editPost form and the post that will be editted
	 */
	@RequestMapping(path = "/goToEditPost", method = RequestMethod.POST)
	public ModelAndView goToEditForm(@ModelAttribute("post")Post post)
	{	
		logger.info("Entering PostController.goToEditForm");
		logger.info("Exiting PostController.goToEditForm");
		return new ModelAndView("editPost", "post", post);
	}
	
	/**
	 * takes a passed Post model and calls the business service to update the post with the matching id in the database
	 * it then gets a full list of all existing posts and returns a ModelAndView of displayPosts with the full list of posts
	 * @param post - the updated post information
	 * @param result - used for data validation
	 * @return - returns a ModelAndView for displayPosts with a list of existing posts
	 */
	@RequestMapping(path = "/editPost", method = RequestMethod.POST)
	public ModelAndView editPost(@Valid @ModelAttribute("post")Post post, BindingResult result)
	{
		logger.info("Entering PostController.editPost");
		try {
		//validate the model
		if(result.hasErrors()) 
		{
			logger.info("Exiting PostController.editPost");
			return new ModelAndView("editPost", "post", post);
		}
		//call the editPost method from the business service and passed the edited post model
		service.editPost(post);
		//call the business services to get all posts and place them inside of an array list
		List<Post> posts = service.getListOfPosts();

		logger.info("Exiting PostController.editPost");

		//return the model and view going to the display posts page with a filled array list of posts
		return new ModelAndView("displayPosts", "posts", posts);
		}
		catch(Exception e) {
			logger.error("PostController.editPost has failed with ", e);
			//throw new DatabaseException("There is an error in the database");
			return new ModelAndView("exception");
		}
	}
	
	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
	/**
	 * navigates to the addPost view
	 * @return model with the addPost view
	 */
	public ModelAndView displayAllPosts(@ModelAttribute("post")Post post) 
	{
		logger.info("Entering PostController.displayAllPosts");
		try {
	
		List<Post> posts = service.getListOfPosts();
		logger.info("Exiting PostController.displayAllPosts");
		return new ModelAndView("main", "posts", posts);
		}
		catch(Exception e) {
			logger.error("PostController.displayAllPosts has failed with ", e);
			//throw new DatabaseException("There is an error in the database");
			return new ModelAndView("exception");
		}
	}
	
	@Autowired
	/**
	 * injects an implementation of the PostBusinessInterface
	 * @param service instance of the PostBusinessInterface
	 */
	public void setPostService(PostBusinessInterface service) 
	{
		this.service = service;
	}
}
