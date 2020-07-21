package com.rong.demo.service;

import com.rong.demo.po.User;


public interface UserService {
    User checkUser(String username, String password);
}
