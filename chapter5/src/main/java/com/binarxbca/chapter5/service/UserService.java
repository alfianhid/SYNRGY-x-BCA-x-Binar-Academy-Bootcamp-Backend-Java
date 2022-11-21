package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.user.User;
import com.binarxbca.chapter5.model.user.UserRequest;
import com.binarxbca.chapter5.model.user.UserResponse;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public UserResponse getUserById(String id);
    public List<User> getAllUsers();
    public UserResponse updateUser(UserRequest userRequest, String id);
    public void deleteUser(String id);
}
