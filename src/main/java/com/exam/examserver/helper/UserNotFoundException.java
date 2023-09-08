package com.exam.examserver.helper;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User with this Username not found in Database, Try with different Username !!!");
    }

    public UserNotFoundException(String msg) {
        super((msg));
    }
}
