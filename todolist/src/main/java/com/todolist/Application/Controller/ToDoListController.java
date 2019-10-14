package com.todolist.Application.Controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.Application.Model.Userdata;
import com.todolist.Application.Service.AddToListService;
import com.todolist.Application.Service.DeleteFromListService;
import com.todolist.Application.Service.LoginService;
/**
 * Class for Rest API 
 * @author AKANSHA
 *
 */
@RestController
public class ToDoListController {

	@Autowired
	LoginService loginService;

	@Autowired
	AddToListService addToListService;

	@Autowired
	DeleteFromListService deleteFromListService;

	Logger logger = LoggerFactory.getLogger(ToDoListController.class);

	/**
	 * Login 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("api/login/{name}/{password}")
	public ResponseEntity login(@PathVariable(value ="name") String userName,@PathVariable(value ="password") String password) throws Exception
	{

		logger.info("----- Started Login method ----------");
		int id = loginService.validUser(userName, password);
		System.out.println("Id = " + id);
		if(id > 0)
		{
			logger.info("----- Found Valid User ----------");
			return ResponseEntity.ok().body(loginService.getUserData(id));
		}
		logger.info("----- End Login method ----------");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
	}

	/**
	 * Fetch Task of the valid users
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("api/fetchTask/{id}")
	public ResponseEntity fetchTasks(@PathVariable(value ="id") String id) throws Exception
	{
		logger.info("----- Started Fetch Task method ----------");
		return ResponseEntity.ok().body(loginService.getUserData(Integer.valueOf(id)));
	}

	/**
	 * Add new created task buy valid users
	 * @param userdata
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("api/addToList")
	public ResponseEntity addToTask(@Valid @RequestBody Userdata userdata) 
	{
		logger.info("----- Started Add Task method ----------");
		userdata.setInsertTime(new Timestamp(System.currentTimeMillis()));
		return ResponseEntity.ok().body(addToListService.addToTask(userdata));
	}

	/**
	 * Deletes task 
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("api/deleteTask/{id}")
	public Map<String, Boolean> deleteTask(@PathVariable(value = "id") String taskId) throws Exception {

		logger.info("----- Started Delete Task method ----------");
		deleteFromListService.deleteTask(taskId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	} 

}
