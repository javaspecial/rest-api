/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.controller;

import com.net.world.model.User;
import com.net.world.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> listOfUser() {
        try {
            return new ResponseEntity(userService.getUserList(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            userService.save(user);
            return new ResponseEntity(userService.getUserList(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody User user) {
        try {
            return new ResponseEntity(userService.update(userId, user), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Integer userId) {
        try {
            return userService.delete(userId);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteOneByUserId/{userEmail}")
    public ResponseEntity<String> deleteOneByUserId(@PathVariable(value = "userEmail") String userEmail) {
        try {
            return userService.deleteOneByUserEmail(userEmail);
        } catch (Exception ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
