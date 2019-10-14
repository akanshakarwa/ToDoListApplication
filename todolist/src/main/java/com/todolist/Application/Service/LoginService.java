package com.todolist.Application.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.Application.Model.Userdata;
import com.todolist.Application.Repository.LoginRepository;


/**
 * service for login and fetch created task
 * @author AKANSHA
 *
 */
@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	Logger logger = LoggerFactory.getLogger(AddToListService.class);
	
	/**
	 * Method to check if user is valid
	 * @param userName
	 * @param password
	 * @return
	 */
	public int validUser(String userName,String password)
	{
		logger.info("----- Entered Service to check valid user ----------");
		if(loginRepository.findValidUser(userName,password) != null)
		{
			logger.debug("Valid User Found");
			return loginRepository.findValidUser(userName,password).getId();
		}
		else
		{
			logger.debug("InValid User Found");
			return 0;
		}

	}

	/**
	 * Method to get all task
	 * @param id
	 * @return
	 */
	public List<Userdata> getUserData(int id)
	{
		logger.debug("Id for User to get task = ",id);
		return loginRepository.findAll(id);
	}
}
