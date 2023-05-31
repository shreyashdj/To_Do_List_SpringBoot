package com.bridgelabz.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - Shreyash Jadhav
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String loginId;
    private String password;
}