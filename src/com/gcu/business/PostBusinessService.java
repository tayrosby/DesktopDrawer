//Desktop_Drawer
//PostBusinessService.java v1
//This class is used to allow crud methods on a post
//Zachary Robbins And Tay Rosby
//10/10/2019

package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.Post;

public class PostBusinessService implements PostBusinessInterface {

	@SuppressWarnings("rawtypes")
	@Autowired
	DataAccessInterface<Post> dao;
	
	@Override
	/**
	 * adds a post to a database
	 * @param post - the post that is being added
	 */
	public void addPost(Post post) {
		dao.create(post);
	}


	@Override
	/**
	 * gets the posts in the database
	 * @return returns the posts in the list
	 */
	public List<Post> getListOfPosts() {
		return dao.findAll();
	}


	/**
	 * deletes a post from the database
	 * @param post - the post that is being deleted
	 */
	@Override
	public void deletePost(Post post) {
		dao.delete(post);
	}

	/**
	 * edits a post inside the database
	 * @param post - the post id and its updated contents
	 */
	@Override
	public void editPost(Post post) {
		dao.update(post);
	}

}