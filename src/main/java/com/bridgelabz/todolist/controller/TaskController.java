package com.bridgelabz.todolist.controller;

import com.bridgelabz.todolist.dto.ResponseDTO;
import com.bridgelabz.todolist.dto.TaskDTO;
import com.bridgelabz.todolist.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author - Shreyash Jadhav
 */

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {
    @Autowired
    ITaskService taskService;

    @PostMapping("add")
    public ResponseEntity<ResponseDTO> addTask(@RequestBody TaskDTO taskDTO, @RequestParam String token) {
        ResponseDTO responseDTO = new ResponseDTO("Task Added Successfully", taskService.addTask(taskDTO, token));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<ResponseDTO> getAll(@RequestParam String token) {
        ResponseDTO responseDTO = new ResponseDTO("Get Task List Successfully", taskService.getAll(token));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<ResponseDTO> deleteByToken(@RequestParam int taskId) {
        ResponseDTO responseDTO = new ResponseDTO("Task Deleted Successfully", taskService.deleteByTaskId(taskId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateByToken(@RequestParam int taskId) {
        ResponseDTO responseDTO = new ResponseDTO("Task Updated Successfully", taskService.updateTask(taskId));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("edit")
    public ResponseEntity<ResponseDTO> editTask(@RequestParam int taskId, @RequestBody TaskDTO taskDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Task Updated Successfully", taskService.editTask(taskId, taskDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}