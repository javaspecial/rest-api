/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.controller;

import com.net.world.model.User;
import com.net.world.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shadath
 */
@RestController
@RequestMapping("/networld")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listOfUser")
    public List<User> listOfUser() {
        return userService.getUserList();
    }

    @PostMapping(value = "/add")
    public List<User> addUser(@RequestBody User user) {
        userService.save(user);
        return userService.getUserList();
    }

    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Integer userId) {
        return userService.delete(userId);
    }

    @DeleteMapping("/deleteOneByUserId/{userEmail}")
    public ResponseEntity<String> deleteOneByUserId(@PathVariable(value = "userEmail") String userEmail) {
        return userService.deleteOneByUserEmail(userEmail);
    }

}
