package com.todolist.Application.Model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for user created task
 * @author AKANSHA
 *
 */
@Entity
public class Userdata {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int prKey;

	int id;
	
	String taskDescription;
	
	Timestamp insertTime;

	
	public int getPrKey() {
		return prKey;
	}

	public void setPrKey(int prKey) {
		this.prKey = prKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	
	

}
