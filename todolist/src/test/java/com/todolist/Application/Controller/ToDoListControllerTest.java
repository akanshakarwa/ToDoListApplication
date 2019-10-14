/**
 * 
 */
package com.todolist.Application.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todolist.Application.Model.Userdata;
import com.todolist.Application.Service.AddToListService;
import com.todolist.Application.Service.DeleteFromListService;
import com.todolist.Application.Service.LoginService;

/**
 * @author AKANSHA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ToDoListControllerTest {

	@Mock
	LoginService mockloginService;
	
	@Mock
	AddToListService mockaddToListService;

	@Mock
	DeleteFromListService mockdeleteFromListService;

	@InjectMocks
	ToDoListController uut;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testValidUser() throws Exception {
		
		List<Userdata> userDataList = new ArrayList<>();
		Userdata u1 = new Userdata();
		u1.setPrKey(1);
		u1.setTaskDescription("Bring Coffee");
		u1.setInsertTime(new Timestamp(System.currentTimeMillis()));
		u1.setId(2);
		userDataList.add(u1);
		Mockito.when(mockloginService.validUser("test","pwd123")).thenReturn(1);
		Mockito.when(mockloginService.getUserData(1)).thenReturn(userDataList);
		ResponseEntity e1 = uut.login("test", "pwd123");
		assertEquals(HttpStatus.OK, e1.getStatusCode());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testInValidUser() throws Exception {
		
		Mockito.when(mockloginService.validUser("test","pwd123")).thenReturn(0);
		ResponseEntity e1 = uut.login("test", "pwd123");
		assertEquals(HttpStatus.BAD_REQUEST, e1.getStatusCode());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testFetchData() throws Exception {
		
		List<Userdata> userDataList = new ArrayList<>();
		Userdata u1 = new Userdata();
		u1.setPrKey(1);
		u1.setTaskDescription("Bring Coffee");
		u1.setInsertTime(new Timestamp(System.currentTimeMillis()));
		u1.setId(2);
		userDataList.add(u1);
		Mockito.when(mockloginService.getUserData(2)).thenReturn(userDataList);
		ResponseEntity e1 = uut.fetchTasks(String.valueOf(2));
		assertEquals(HttpStatus.OK, e1.getStatusCode());
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testAddData() throws Exception {
		
		Userdata u1 = new Userdata();
		u1.setTaskDescription("Bring Coffee");
		u1.setInsertTime(new Timestamp(System.currentTimeMillis()));
		u1.setId(2);
		u1.setPrKey(2);
		Mockito.when(mockaddToListService.addToTask(u1)).thenReturn(u1);
		ResponseEntity e1 = uut.addToTask(u1);
		assertEquals(HttpStatus.OK, e1.getStatusCode());
		
	}
	
	@Test
	public void testDeleteData() throws Exception {
		
		Mockito.doNothing().when(mockdeleteFromListService).deleteTask(String.valueOf(2));
		Map<String, Boolean> response = uut.deleteTask(String.valueOf(2));
		assertTrue(response.get("deleted"));
		
	}
	
	
	
	

}
