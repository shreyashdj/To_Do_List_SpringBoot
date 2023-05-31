package com.bridgelabz.todolist.service;

import com.bridgelabz.todolist.dto.TaskDTO;
import com.bridgelabz.todolist.entity.TaskData;
import com.bridgelabz.todolist.entity.UserData;
import com.bridgelabz.todolist.repository.TaskRepository;
import com.bridgelabz.todolist.repository.UserRepository;
import com.bridgelabz.todolist.util.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author - Shreyash Jadhav
 */

@Service
public class TaskService implements ITaskService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TokenService tokenService;

    public String addTask(TaskDTO taskDTO, String token) {
        UserData user = userRepository.findById(tokenService.decodeToken(token)).get();
        TaskData taskData = new TaskData(taskDTO);
        taskData.setUserId(user.getUserId());
        taskData.setStartDate(LocalDate.now());
        taskRepository.save(taskData);
        return "Task Added";
    }

    public List<TaskData> getAll(String token) {
        UserData userData = userRepository.findById(tokenService.decodeToken(token)).get();
        return taskRepository.findByUserId(userData.getUserId());
    }

    public String deleteByTaskId(int taskId) {
       taskRepository.deleteById(taskId);
       return "Task Deleted Successfully";
    }

    public String updateTask(int taskId){
            TaskData taskData = taskRepository.findById(taskId).get();
            taskData.setDone(!taskData.isDone());
            if (!taskData.isDone()) {
                taskData.setEndDate(null);
            } else {
                taskData.setEndDate(LocalDate.now());
            }
            taskRepository.save(taskData);
            return "Task Updated";
    }

    public String editTask(int taskId, TaskDTO taskDTO) {
        TaskData taskData = taskRepository.findById(taskId).get();
        taskData.setTaskTitle(taskDTO.getTaskTitle());
        taskData.setTaskDescription(taskDTO.getTaskDescription());
        taskRepository.save(taskData);
        return "Task Updated";
    }
}