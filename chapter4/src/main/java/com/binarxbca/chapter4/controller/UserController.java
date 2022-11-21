package com.binarxbca.chapter4.controller;

import com.binarxbca.chapter4.model.Users;
import com.binarxbca.chapter4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user){
        return userService.createUser(user);
    }

    @GetMapping("/id/{id}")
    public Users getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update")
    public Users updateUser(@RequestBody Users user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String id){
        userService.deleteUser(id);
    }
}
