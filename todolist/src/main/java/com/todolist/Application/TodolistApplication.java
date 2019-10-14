package com.todolist.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author AKANSHA
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class TodolistApplication {

	/**
	 * Default method of Spring boot starter
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
