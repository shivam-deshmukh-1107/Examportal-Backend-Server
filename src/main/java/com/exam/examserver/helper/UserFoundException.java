package com.exam.examserver.helper;

public class UserFoundException extends Exception{

    public UserFoundException() {
        super("User with this Username is already present, Try with different Username !!!");
    }

    public UserFoundException(String msg) {
        super((msg));
    }
}
