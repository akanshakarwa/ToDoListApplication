package com.todolist.Application.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.Application.Model.Userdata;
import com.todolist.Application.Repository.UserTasksRepository;

/**
 * service to add new task
 * @author AKANSHA
 *
 */
@Service
public class AddToListService {

	@Autowired
	UserTasksRepository addtaskRepository;

	Logger logger = LoggerFactory.getLogger(AddToListService.class);

	/**
	 * method to add task
	 * @param userdata
	 * @return
	 */
	public Userdata addToTask(Userdata userdata)
	{
		logger.info("----- Entered Service to add task ----------");
		logger.debug("User Id = ", userdata.getId());
		return addtaskRepository.save(userdata);
	}
}
