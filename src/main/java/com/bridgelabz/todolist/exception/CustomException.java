package com.bridgelabz.todolist.exception;

/**
 * @author - Shreyash Jadhav
 */

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}