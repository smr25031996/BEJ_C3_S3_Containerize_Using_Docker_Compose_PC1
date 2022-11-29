package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "LogIn Failed userName And password not matching")
public class UserNotFoundException extends Exception {
}
