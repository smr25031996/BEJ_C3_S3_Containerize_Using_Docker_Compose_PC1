package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserInterface {
    public User saveUser(User user);
    public List<User>getAllUsers();
    public User logInCheck(String userName,String password) throws UserNotFoundException;
    public Optional<User> getByUserId(int userId);

    public boolean deleteUser(int userId);
}
