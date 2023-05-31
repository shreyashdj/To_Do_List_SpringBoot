package com.bridgelabz.todolist.service;

import com.bridgelabz.todolist.dto.LoginDTO;
import com.bridgelabz.todolist.dto.UserDTO;
import com.bridgelabz.todolist.entity.UserData;

public interface IUserService {
    UserData loginUser(LoginDTO loginDTO);
    public String addUser(UserDTO userDTO);
}
