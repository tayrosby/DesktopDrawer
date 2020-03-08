//Desktop_Drawer
//ApplicationConfig.java v2
//These are all of the spring bean configuration files in java
//Zachary Robbins And Tay Rosby
//11/3/2019
package com.gcu;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gcu.business.PostBusinessInterface;
import com.gcu.business.PostBusinessService;
import com.gcu.business.UserBusinessInterface;
import com.gcu.business.UserBusinessService;
import com.gcu.controller.PostController;
import com.gcu.controller.LoginController;
import com.gcu.controller.RegistrationController;
import com.gcu.data.DataAccessInterface;
import com.gcu.data.PostDataService;
import com.gcu.data.UserDataService;
import com.gcu.model.Post;
import com.gcu.model.User;


@Configuration
public class ApplicationConfig 
{
	/**
	 * creates an instance of LoginController for Dependency Injection
	 * @return returns an instance of the LoginController
	 */
	@Bean(name="loginController")
	public LoginController getLoginController()
	{
		return new LoginController();
	}
	
	
	/**
	 * creates an instance of the PostController for Dependency Injection
	 * @return returns an instance of PostController
	 */
	@Bean(name="postController")
	public PostController getPostController()
	{
		return new PostController();
	}
	
	/**
	 * creates an instance of RegistrationController for Dependency Injection
	 * @return returns an instance of the RegistrationController
	 */
	@Bean(name="registrationController")
	public RegistrationController getRegistrationController()
	{
		return new RegistrationController();
	}
	
	/**
	 * creates an instance of PostBusinessInterface for Dependency Injection
	 * @return returns an instance of the PostBusinessInterface
	 */
	@Bean(name="postService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public PostBusinessInterface getPostService()
	{
		return new PostBusinessService();
	}
	
	/**
	 * creates an instance of UserBusinessInterface for Dependency Injection
	 * @return returns an instance of the UserBusinessInterface
	 */
	@Bean(name="userService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserBusinessInterface getUserService() {
		return new UserBusinessService();
	}
	
	/**
	 * creates an instance of the DataAccessInterface using a type of User for Dependency Injection
	 * @return returns an instance of UserDataService
	 */
	@Bean(name="userDataService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<User> getUserDataService() {
		return new UserDataService();
	}
	
	/**
	 * creates an instance of the DataAccessInterface using a type of Post for Dependency Injection 
	 * @return returns an instance of PostDataService
	 */
	@Bean(name="postDataService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataAccessInterface<Post> getPostDataService() {
		return new PostDataService();
	}
	/**
	 * creates an instance of DataSource to be injected into the dataService for database connections
	 * @return returns an instance of DataSource
	 */
	@Bean(name="dataSource")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getdataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://y2w3wxldca8enczv.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/olagfzo6v1mxmlon");
		dataSource.setUsername("sl4y44zudm79o8qd");
		dataSource.setPassword("wddvwco4bkir08z2");
		 
		return dataSource;
	}
}
