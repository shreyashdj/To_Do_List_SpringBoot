package com.bridgelabz.todolist.controller;

import com.bridgelabz.todolist.dto.LoginDTO;
import com.bridgelabz.todolist.dto.ResponseDTO;
import com.bridgelabz.todolist.dto.UserDTO;
import com.bridgelabz.todolist.entity.UserData;
import com.bridgelabz.todolist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author - Shreyash Jadhav
 */

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("add")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully", userService.addUser(userDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        UserData user = userService.loginUser(loginDTO);
        ResponseDTO responseDTO;
        if (user != null) {
            responseDTO = new ResponseDTO("Login Successful", user);
        } else {
            responseDTO = new ResponseDTO("Login Not Successful", null);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}