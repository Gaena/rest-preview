package com.gaena.restpreview.services;


import com.gaena.restpreview.dao.UserMapper;
import com.gaena.restpreview.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * Save new User
     * */
    public User saveUser(User user){
        userMapper.saveUser(user);
        System.out.println(user.getId());
        return user;
    }
}
