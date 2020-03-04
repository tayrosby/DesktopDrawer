//Desktop_Drawer
//UserDataService.java v2
//This is the Data Service for all CRUD functions and other database pulls for Users and their respective information 
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
import com.gcu.model.Credentials;
import com.gcu.model.User;

public class UserDataService implements DataAccessInterface<User> {

	/**
	 * datasource connection to the databse
	 */
	@SuppressWarnings("unused")
	private DataSource datasource;
	
	@SuppressWarnings("unused")
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * dependency injection for datasource and jdbcTemplateObject
	 * @param dataSource - used to connect to the database
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.datasource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Retrieves all users from the database
	 * @return returns a list of all Users in the database
	 */
	@Override
	public List<User> findAll() {
		//Create a sql statement
		String sql = "SELECT * FROM users";
		//Create an empty list to receive selected users
		List<User> users = new ArrayList<User>();
		//try/catch to handle exceptions
		try {
			//Instance of SqlRowSet to run and hold results of SELECT query run by a jdbcTemplateObject
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			//parse through pulled data from database
			while(srs.next()) {
				users.add(new User(srs.getInt("ID"),
									srs.getString("FIRSTNAME"),
									srs.getString("LASTNAME"),
									srs.getString("EMAIL"),
									new Credentials(srs.getString("PASSWORD"),
													srs.getString("USERNAME")),
									srs.getString("PHONENUMBER")));
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw new DatabaseException("There is an error in the database");
			}
		//return list of users
		return users;
	}
	
	/**
	 * Takes passed user model and creates a new row in the database
	 * @return the passed user
	 */
	@Override
	public User create(User t) {
		//Create sql statement
		String sql = "INSERT INTO users(FIRSTNAME, LASTNAME, EMAIL, PASSWORD, USERNAME, PHONENUMBER) VALUES (?,?,?,?,?,?)";
		//try/catch to handle exceptions
		try {
			//run the sql statement through a jdbcTemplateObject, using the above created sql statement and values from the passed user object,
			//capture results with an int
			int res = jdbcTemplateObject.update(sql, t.getFirstName(), 
													t.getLastName(), 
													t.getCredentials().getEmail(), 
													t.getCredentials().getPassword(),
													t.getUsername(),
													t.getPhonenumber());
			
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}
		return t;
	}

	/**
	 * takes passed user credentials inside of a user model and searches for a corresponding user row in the user table
	 * @return user model with found data
	 */
	@Override
	public User findBy(User t) {
		//Make a string sql statement
		String sql = "SELECT * FROM users WHERE EMAIL = ? AND PASSWORD = ?";
		//create a user with the submitted information to be filled with data from the sql statement, 
		User user = new User(0,"", "", "", t.getCredentials(), "");
		try {
			//execute the SQL statement and capture the results inside of a SqlRowSet
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, t.getCredentials().getEmail(), t.getCredentials().getPassword());
			
			//parse through the queried information and pull out the selected user
			while(srs.next()) {
				user = new User(srs.getInt("ID"),
								srs.getString("FIRSTNAME"),
								srs.getString("LASTNAME"),
								srs.getString("EMAIL"),
								new Credentials(srs.getString("PASSWORD"),
												srs.getString("USERNAME")),
								srs.getString("PHONENUMBER"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new DatabaseException("There is an error in the database");
		}
		//Return either a completely filled user object or a user object with just the credential information
		return user;
	}

	/**
	 * update function - future implementation
	 */
	@Override
	public User update(User t) {
		throw new UnsupportedOperationException("Invalid operation for User"); 
		//return null;
	}

	/**
	 * delete function - future implementation
	 */
	@Override
	public User delete(User t) {
		throw new UnsupportedOperationException("Invalid operation for User"); 
		//return null;
	}
	
	/**
	 * checks for instances of already existing users based on criteria
	 * @return - returns the amount of existing users based on the given criteria
	 */
	@Override
	public int check(User t) {
		//Make a string sql statement
				String sql = "SELECT * FROM users WHERE EMAIL = ?";
				
				int result = 0;
				
				try {
					//execute the SQL statement and capture the results inside of a SqlRowSet
					SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, t.getCredentials().getEmail());
					
					while(srs.next()) {
						result++;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					throw new DatabaseException("There is an error in the database");
				}
				//Return either a completely filled user object or a user object with just the credential information
				return result;	
	}

}