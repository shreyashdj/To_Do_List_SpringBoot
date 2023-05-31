package com.bridgelabz.todolist.entity;

import com.bridgelabz.todolist.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - Shreyash Jadhav
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    private String firstName;
    private String lastName;
    private String loginId;
    private String password;
    private String token;


    public UserData(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.loginId = userDTO.getLoginId();
        this.password = userDTO.getPassword();
    }
}