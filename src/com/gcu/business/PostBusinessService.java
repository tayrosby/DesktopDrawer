//Desktop_Drawer
//PostBusinessService.java v1
//This class is used to allow crud methods on a post
//Zachary Robbins And Tay Rosby
//10/10/2019

package com.gcu.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.Post;

public class PostBusinessService implements PostBusinessInterface {

	@SuppressWarnings("rawtypes")
	@Autowired
	DataAccessInterface<Post> dao;

	Logger logger = LoggerFactory.getLogger(PostBusinessService.class);
	
	@Override
	/**
	 * adds a post to a database
	 * @param post - the post that is being added
	 */
	public void addPost(Post post) {
		logger.info("Entering PostBusinessService.addPost");
		dao.create(post);
		logger.info("Exiting PostBusinessService.addPost");
	}


	@Override
	/**
	 * gets the posts in the database
	 * @return returns the posts in the list
	 */
	public List<Post> getListOfPosts() {
		logger.info("Entering PostBusinessService.getListsOfPosts");
		logger.info("Exiting PostBusinessService.getListsOfPosts");
		return dao.findAll();
	}


	/**
	 * deletes a post from the database
	 * @param post - the post that is being deleted
	 */
	@Override
	public void deletePost(Post post) {
		logger.info("Entering PostBusinessService.deletePost");
		dao.delete(post);
		logger.info("Exiting PostBusinessService.deletePost");
	}

	/**
	 * edits a post inside the database
	 * @param post - the post id and its updated contents
	 */
	@Override
	public void editPost(Post post) {
		logger.info("Entering PostBusinessService.editPost");
		dao.update(post);
		logger.info("Exiting PostBusinessService.editPost");
	}

}
