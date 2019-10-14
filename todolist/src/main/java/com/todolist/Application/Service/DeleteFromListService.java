package com.todolist.Application.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.Application.Repository.UserTasksRepository;

/**
 * Service to delete tasks
 * @author AKANSHA
 *
 */
@Service
public class DeleteFromListService {

	@Autowired
	UserTasksRepository deleteRepository;
	
	Logger logger = LoggerFactory.getLogger(DeleteFromListService.class);
	
	/**
	 * Method to delete task
	 * @param taskId
	 */
	public void deleteTask(String taskId) {

		logger.info("----- Entered Service to delete task ----------");
		logger.debug("Task Id for deleteion = ",taskId);
		deleteRepository.deleteById(Integer.valueOf(taskId));
	}

	
}
