package com.had.springbootdemo.service.impl;

import com.had.springbootdemo.repository.UserRepository;
import com.had.springbootdemo.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


}
