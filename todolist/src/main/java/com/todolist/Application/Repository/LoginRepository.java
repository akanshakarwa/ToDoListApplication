package com.todolist.Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.todolist.Application.Model.User;
import com.todolist.Application.Model.Userdata;

/**
 * Repository for valid users and fetch task
 * @author AKANSHA
 *
 */
public interface LoginRepository extends CrudRepository<User, String>{

	@Query(value = "SELECT * FROM User u WHERE u.userName = :userName and u.password = :password", nativeQuery = true)
	User findValidUser(@Param("userName") String status, @Param("password") String password);
	
	
	
	@Query(value = "SELECT u FROM Userdata u WHERE u.id = :id")
	List<Userdata> findAll(@Param("id") int id);
}
