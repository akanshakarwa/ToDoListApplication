package com.todolist.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.Application.Model.Userdata;

/**
 * Repository for creating and deleting task
 * @author AKANSHA
 *
 */
public interface UserTasksRepository extends JpaRepository<Userdata, Integer>{

}
