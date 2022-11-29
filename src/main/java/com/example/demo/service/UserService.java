package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterface {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User logInCheck(String userName, String password) throws UserNotFoundException {
        User userObject = userRepository.findByUserNameAndPassword(userName, password);
        if (userObject.equals(null)) {
            throw new UserNotFoundException();
        } else {
            return userObject;
        }
    }

    @Override
    public Optional<User> getByUserId(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public boolean deleteUser(int userId) {
         userRepository.deleteById(userId);
         return  true;
    }
}
