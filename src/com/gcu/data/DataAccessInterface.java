//Desktop_Drawer
//DataAccessInterface.java v1
//This is the interface for Data Access Interfaces 
//Zachary Robbins And Tay Rosby
//11/10/2019
package com.gcu.data;

import java.util.List;

public interface DataAccessInterface <T> {

	/**
	 * creates an object in the database
	 * @param t - generic data type
	 * @return returns the passed object
	 */
	public T create(T t);
	
	/**
	 * finds all the objects in the database
	 * @return a list of objects
	 */
	public List<T> findAll();
	
	/**
	 * finds all the objects in the database by a criteria
	 * @param t - generic data type
	 * @return returns the passed object
	 */
	public T findBy(T t);
	
	/**
	 * updates an object in the database
	 * @param t - generic data type
	 * @return returns the passed object
	 */
	public T update(T t);
	
	/**
	 * deletes an object from the database
	 * @param t - generic data type
	 * @return returns the passed object
	 */
	public T delete(T t);
	
	/**
	 * checks for existing instances of models based on criteria
	 * @param t - generic data type
	 * @return - returns number of rows that match criteria
	 */
	public int check(T t);
}