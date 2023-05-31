package com.bridgelabz.todolist.service;

import com.bridgelabz.todolist.dto.TaskDTO;
import com.bridgelabz.todolist.entity.TaskData;
import java.util.List;

public interface ITaskService {

    List<TaskData> getAll(String token);
    public String addTask(TaskDTO taskDTO, String token);
    String deleteByTaskId(int taskId);
    public String updateTask(int taskId);

    String editTask(int taskId, TaskDTO taskDTO);
}
