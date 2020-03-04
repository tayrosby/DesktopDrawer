//Desktop_Drawer
//PostBusinessInterface.java v1
//This interface is used to create a post business class
//Zachary Robbins And Tay Rosby
//10/10/2019

package com.gcu.business;

import java.util.List;

import com.gcu.model.Post;

public interface PostBusinessInterface {
	
	/**
	 * adds a post to a list of posts
	 * @param post represents the post being added
	 */
	public void addPost(Post post);
	
	/**
	 * gets the list of posts
	 * @return returns the list of posts
	 */
	public List<Post> getListOfPosts();
	
	/**
	 * deletes a post from the database
	 * @param post - the post that is being deleted
	 */
	public void deletePost(Post post);

	/**
	 * updates a post in the database
	 * @param post - the post id and updated contents
	 */
	public void editPost(Post post);
	
}