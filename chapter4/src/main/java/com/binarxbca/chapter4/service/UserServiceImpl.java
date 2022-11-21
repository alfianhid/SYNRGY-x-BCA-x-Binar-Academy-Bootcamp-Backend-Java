package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.constant.ResponseMessage;
import com.binarxbca.chapter4.exception.DataNotFoundException;
import com.binarxbca.chapter4.model.Users;
import com.binarxbca.chapter4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Users createUser(Users user) {
        user.setUser_status(Boolean.TRUE);
        return userRepository.save(user);
    }

    @Override
    public Users getUserById(String id) {
        verifyUser(id);
        return userRepository.findById(id).get();
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users updateUser(Users user) {
        verifyUser(user.getUser_id());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        verifyUser(id);
        userRepository.deleteById(id);
    }

    private void verifyUser(String id){
        if(!userRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "user", id);
            throw new DataNotFoundException(message);
        }
    }
}
