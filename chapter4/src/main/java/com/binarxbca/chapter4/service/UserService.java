package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.model.Users;

import java.util.List;

public interface UserService {
    public Users createUser(Users user);
    public Users getUserById(String id);
    public List<Users> getAllUsers();
    public Users updateUser(Users user);
    public void deleteUser(String id);
}
