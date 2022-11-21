package com.binarxbca.chapter5.validator;

import com.binarxbca.chapter5.constant.ResponseMessage;
import com.binarxbca.chapter5.exception.DataAlreadyExistsException;
import com.binarxbca.chapter5.exception.DataNotFoundException;
import com.binarxbca.chapter5.exception.EmptyFieldException;
import com.binarxbca.chapter5.model.user.User;
import com.binarxbca.chapter5.model.user.UserRequest;
import com.binarxbca.chapter5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserValidator {
    @Autowired
    UserRepository userRepository;

    public void verifyUserId(String id){
        if(!userRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "user", id);
            throw new DataNotFoundException(message);
        }
    }

    public void verifyUserEmailAndUsername(User user){
        List<User> email = userRepository.findUserByEmail(user.getEmail());

        if(!email.isEmpty()) {
            String message = String.format(ResponseMessage.EMAIL_ALREADY_EXISTS, "user", user.getEmail());
            throw new DataAlreadyExistsException(message);
        }

        List<User> username = userRepository.findUserByUsername(user.getUsername());

        if(!username.isEmpty()) {
            String message = String.format(ResponseMessage.USERNAME_ALREADY_EXISTS, "user", user.getUsername());
            throw new DataAlreadyExistsException(message);
        }
    }
}