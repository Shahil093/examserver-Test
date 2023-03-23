package com.examserver.service;

import java.util.Set;

import com.examserver.model.User;
import com.examserver.model.UserRole;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public  void deleteUser(Long userId);



}
