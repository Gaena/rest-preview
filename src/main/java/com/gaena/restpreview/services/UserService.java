package com.gaena.restpreview.services;


import com.gaena.restpreview.dao.UserMapper;
import com.gaena.restpreview.exceptions.GeneralException;
import com.gaena.restpreview.exceptions.UserNotFoundException;
import com.gaena.restpreview.model.Role;
import com.gaena.restpreview.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {


    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * Save new User
     */
    public User saveUser(User user) {
        if (Objects.isNull(user.getRole())) {
            user.setRole(Role.USER);
        }
        userMapper.saveUser(user);
        return user;
    }


    /**
     * get Saved user if exists
     */
    public User getUser(Long id) {
        Optional<User> optionalUser = Optional.ofNullable(userMapper.getUserById(id));
        return optionalUser.orElseThrow(UserNotFoundException::new);
    }


    /**
     * get All Users List
     */
    public List<User> getAllUsers() {
        List<User> userList = userMapper.getAllUsers();
        if (userList.isEmpty()) {
            throw new GeneralException("No data found");
        }
        return userList;
    }


    /**
     * Update existing user
     */
    public void updateUser(User user) {
        Optional<User> existingUser = Optional.ofNullable(userMapper.getUserById(user.getId()));
        if (existingUser.isEmpty()) throw new UserNotFoundException();
        existingUser.ifPresent(
                exUser -> {
                    BeanUtils.copyProperties(user, existingUser);
                    userMapper.updateUser(user);
                }
        );
    }


    /**
     * Delete Existing user
     */
    public void deleteUser(User user) {
        Optional<User> existingUser = Optional.ofNullable(userMapper.getUserById(user.getId()));
        if (existingUser.isEmpty()) throw new UserNotFoundException();
        existingUser.ifPresent(
                exUser -> userMapper.deleteUser(user.getId())
        );
    }

}
