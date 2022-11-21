package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.constant.ResponseMessage;
import com.binarxbca.chapter5.model.user.User;
import com.binarxbca.chapter5.model.user.UserRequest;
import com.binarxbca.chapter5.model.user.UserResponse;
import com.binarxbca.chapter5.service.UserService;
import com.binarxbca.chapter5.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.binarxbca.chapter5.constant.ResponseMessage.MSG;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        Map<String, Object> response = new HashMap<>();

        userService.createUser(user);

        response.put(MSG, ResponseMessage.DATA_INSERTED_SUCCESS);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    public ResponseEntity getUserById(@RequestParam(value = "id") String id){
        Map<String, Object> response = new HashMap<>();

        try {
            UserResponse userResponse = userService.getUserById(id);

            return new ResponseEntity(userResponse, HttpStatus.OK);
        } catch (Exception e) {
            response.put(MSG, ResponseMessage.NOT_FOUND_WITH_REASON + e.getMessage());
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity getAllUsers(){
        Map<String, Object> response = new HashMap<>();

        try {
            List<User> listOfUsers = userService.getAllUsers();

            return new ResponseEntity(listOfUsers, HttpStatus.OK);
        } catch (Exception e) {
            response.put(MSG, ResponseMessage.NOT_FOUND_WITH_REASON + e.getMessage());
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@Valid @RequestBody UserRequest userRequest,
                                     @RequestParam(value = "id") String id) {
        Map<String, Object> response = new HashMap<>();

        try {
            userService.updateUser(userRequest, id);

            response.put(MSG, ResponseMessage.DATA_UPDATED_SUCCESS);
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response.put(MSG, ResponseMessage.DATA_UPDATED_ERROR + e.getMessage());
            return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestParam(value = "id") String id){
        Map<String, Object> response = new HashMap<>();

        try {
            userService.deleteUser(id);

            response.put(MSG, ResponseMessage.DATA_DELETED_SUCCESS);
            return new ResponseEntity(response, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response.put(MSG, ResponseMessage.DATA_DELETED_ERROR + e.getMessage());
            return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
