package com.binarxbca.chapter5.service.impl;

import com.binarxbca.chapter5.model.user.User;
import com.binarxbca.chapter5.model.user.UserRequest;
import com.binarxbca.chapter5.model.user.UserResponse;
import com.binarxbca.chapter5.repository.UserRepository;
import com.binarxbca.chapter5.service.UserService;
import com.binarxbca.chapter5.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserResponse getUserById(String id) {
        // verify id
        UserValidator userValidator = new UserValidator();
        userValidator.verifyUserId(id);

        User user = userRepository.findById(id).get();

        return new UserResponse(user.getCreatedAt(), user.getUpdatedAt(), user.getId(), user.getFirstName(),
                user.getLastName(), user.getUsername(), user.getEmail(), user.getStatus());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, String id) {
        UserValidator userValidator = new UserValidator();

        // verify id
        userValidator.verifyUserId(id);
        // verify email and username
//        userValidator.verifyUserEmailAndUsername(userRequest);

        User user = new User();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());

        User updatedUser = userRepository.save(user);

        return new UserResponse(updatedUser.getCreatedAt(), updatedUser.getUpdatedAt(), updatedUser.getId(),
                updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getUsername(),
                updatedUser.getEmail(), updatedUser.getStatus());
    }

    @Override
    public void deleteUser(String id) {
        // verify id
        UserValidator userValidator = new UserValidator();
        userValidator.verifyUserId(id);

        userRepository.deleteById(id);
    }
}
