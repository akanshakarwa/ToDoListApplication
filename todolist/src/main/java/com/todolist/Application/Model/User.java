package com.todolist.Application.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class for user credentials
 * @author AKANSHA
 *
 */
@Entity
public class User {
	
	@Id
	int id;
	
	String username;
	
	String password;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNname() {
		return username;
	}
              
	public void setUserNname(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 
	

}
