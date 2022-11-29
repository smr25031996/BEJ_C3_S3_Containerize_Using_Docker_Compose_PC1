package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
