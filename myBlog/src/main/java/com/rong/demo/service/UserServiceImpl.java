package com.rong.demo.service;

import com.rong.demo.dao.UserRepository;
import com.rong.demo.po.User;
import com.rong.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, MD5Util.code(password));
    }
}
