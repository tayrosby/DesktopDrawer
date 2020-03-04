//Desktop_Drawer
//PostDataService.java v2
//This is the Data Service for all CRUD functions and other database pulls for posts and their respective information 
//Zachary Robbins And Tay Rosby
//11/10/2019

package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.DatabaseException;
import com.gcu.model.Post;

public class PostDataService implements DataAccessInterface<Post> {
	
	@SuppressWarnings("unused")
	/**
	 * datasource connection to the databse
	 */
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Takes the values from a post object and puts it into the database
	 * @return a created post
	 */
	@Override
	public Post create(Post post) {
		String sql = "INSERT INTO desktopdrawer.posts(TITLE, CONTENT, LIKE_COUNT, users_id) VALUES (?, ?, ?, ?)";

		
		try {
			//queries the sql statement with the values taken from the post object
			int rows = jdbcTemplateObject.update(sql, post.getTitle(),
												   	  post.getContent(),
													  0,
													  1);
			}
		
		catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}
		
		return post;
	}

	/**
	 * grabs all the posts in the database
	 * @return a list of posts
	 */
	@Override
	public List<Post> findAll() {
		String sql = "SELECT * FROM desktopdrawer.posts";
		
		//a empty list of posts
		List<Post> posts = new ArrayList<Post>();
		
		try {
			//queries the sql statement
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			
			//inserts every object found in the database into an array
			while(srs.next()) { posts.add(new Post(srs.getInt("USERS_ID"),
												   srs.getInt("ID"),
							                       srs.getString("TITLE"),
								                   srs.getString("CONTENT")));
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}

		//returns a list of posts
		return posts;
	}

	/**
	 * finds a post based on id
	 * @param post - a post model holding the posts id 
	 * @return - returns a post at the given id
	 */
	@Override
	public Post findBy(Post post) {
		//make a SQL statement as a string
		String sql = "SELECT * FROM posts WHERE ID = ?";
		//create an empty post model to be filled with the results of the query
		Post result = new Post();
		//begin try catch for exception handling
		try
		{
			//make a SQLRowSet to catch the results of the query from a jdbcTemplateObject with the above SQL statement
			//and variables from the passed post model
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, post.getID());
			//parse through the results of the query
			while(srs.next()) { 
				result.setID(srs.getInt("ID"));
				result.setUserID(srs.getInt("USERS_ID"));
                result.setTitle(srs.getString("TITLE"));
	            result.setContent(srs.getString("CONTENT"));
}
		} catch(Exception e) {
			//currently printing stack trace, will be replaced by custom exception handling
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}
		//return what was queried from the database
		return result;
	}

	/**
	 * takes a post model and updates a post with the given id
	 * @param post - post information that needs to be updated and the location id of the post
	 * @return - returns the updated post
	 */
	@Override
	public Post update(Post post) {
		System.out.println(post.getID() + post.getTitle() + post.getContent());
		//make a SQL statement as as string
		String sql = "UPDATE posts SET TITLE = ?, CONTENT = ? WHERE ID = ?";
		//initialize an int to return for effected rows
		int results = 0;	
		//begin try catch block for  exception handling
		try 
		{
			//create an int to catch the row count of effected rows from a jdbcTemplateObject performing an update with the above Sql statement
			//and information from the passed post model
			results = jdbcTemplateObject.update(sql, post.getTitle(), post.getContent(), post.getID());

		}catch(Exception e) {
			//currently printing stack trace, will be replaced by custom exception handling
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}
		//return the amount of effected rows
		//return results;
		return post;
	}

	/**
	 * takes a post model, retrieves the id, and deletes the corresponding row in the database
	 * @param post - post information that needs to be deleted
	 * @return - returns the deleted post
	*/
	@Override
	public Post delete(Post post) {
		String sql = "DELETE FROM desktopdrawer.posts WHERE ID = ?";
		
		try {

			//queries the sql statement
			int rows = jdbcTemplateObject.update(sql, post.getID());

		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}
		
		//return results
		return post;
	}
	
	/**
	 * dependency injection
	 * @param dataSource - used to connect to the database
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * checks for instances of a post  based on criteria - not used
	 */
	@Override
	public int check(Post t) {
		throw new UnsupportedOperationException("Invalid operation for Post"); 
		//return 0;
	}

}