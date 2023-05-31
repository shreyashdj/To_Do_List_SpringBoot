package com.bridgelabz.todolist.repository;

import com.bridgelabz.todolist.entity.TaskData;
import com.bridgelabz.todolist.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author - Shreyash Jadhav
 */

@Repository
public interface TaskRepository extends JpaRepository<TaskData, Integer>{
    @Query(value = "select * from task_data where user_id = :id", nativeQuery = true)
    List<TaskData> findByUserId(int id);
}