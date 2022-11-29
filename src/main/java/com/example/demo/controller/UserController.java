package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.SecurityTokenGenerator;
import com.example.demo.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final UserInterface userInterface;
    private SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public UserController(UserInterface userInterface, SecurityTokenGenerator securityTokenGenerator) {
        this.userInterface = userInterface;
        this.securityTokenGenerator = securityTokenGenerator;
    }



    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userInterface.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/fetchAll")
    public ResponseEntity<?> fetchUsers() {
        return new ResponseEntity<>(userInterface.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/fetchById/{userId}")
    public ResponseEntity<?> fetchUser(@PathVariable int userId) {
        return new ResponseEntity<>(userInterface.getByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/logIn")
    public ResponseEntity<?> logIn(@RequestBody User user) throws UserNotFoundException {
        try {
            userInterface.logInCheck(user.getUserName(), user.getPassword());
            Map<String,String>secretKey=new HashMap<>();
            secretKey=securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(secretKey, HttpStatus.FOUND);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {
            return new ResponseEntity<>("logIn UnSuccessful", HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/api/v1/deleteUser/{userId}")
    public ResponseEntity<?>deleteUser(@PathVariable int userId){
        return new ResponseEntity<>(userInterface.deleteUser(userId),HttpStatus.GONE);

    }


}
