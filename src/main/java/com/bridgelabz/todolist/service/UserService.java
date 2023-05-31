package com.bridgelabz.todolist.service;

import com.bridgelabz.todolist.dto.LoginDTO;
import com.bridgelabz.todolist.dto.UserDTO;
import com.bridgelabz.todolist.entity.UserData;
import com.bridgelabz.todolist.exception.CustomException;
import com.bridgelabz.todolist.repository.UserRepository;
import com.bridgelabz.todolist.util.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author - Shreyash Jadhav
 */

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenService tokenService;

    public String addUser(UserDTO userDTO) {
        UserData userData = new UserData(userDTO);
        userRepository.save(userData);
        String token = tokenService.createToken(userData.getUserId());
        userData.setToken(token);
        userRepository.save(userData);
        return "User Added";
    }

    public UserData loginUser(LoginDTO loginDTO) {
        UserData user = userRepository.findByLoginId(loginDTO.getLoginId());
        if (user != null) {
            if (user.getPassword().equals(loginDTO.getPassword())) {
                System.out.println("Login Successful");
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}