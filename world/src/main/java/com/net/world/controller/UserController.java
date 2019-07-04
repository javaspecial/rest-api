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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author shadath
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/networld")
public class UserController {

    @Autowired
    private UserService userService;
    final private Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping("/list_of_user")
    public ResponseEntity<?> listOfUser() {
        try {
            List<User> userList = userService.getUserList();
            logger.info(userList.toString());
            return new ResponseEntity(userList, HttpStatus.OK);
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find_by_user_email/{userEmail}")
    public ResponseEntity<?> findByUserEmail(@PathVariable(value = "userEmail") String userEmail) {
        try {
            List<User> userList = userService.findByUserEmail(userEmail);
            logger.info(userList.toString());
            return new ResponseEntity(userList, HttpStatus.OK);
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find_by_user_id/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable(value = "userId") Integer userId) {
        try {
            List<User> userList = userService.findByUserId(userId);
            logger.info(userList.toString());
            return new ResponseEntity(userList, HttpStatus.OK);
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add_user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            userService.save(user);
            logger.info(user.toString());
            return new ResponseEntity(userService.getUserList(), HttpStatus.OK);
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_user/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable(value = "userId") Integer userId, @Valid @RequestBody User user) {
        try {
            logger.info(user.toString());
            User updatedUser = userService.update(userId, user);
            logger.info(updatedUser.toString());
            return new ResponseEntity(updatedUser, HttpStatus.OK);
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_user_by_user_id/{userId}")
    public ResponseEntity<String> deleteUserByUserId(@PathVariable(value = "userId") Integer userId) {
        try {
            ResponseEntity responseMSG = userService.delete(userId);
            logger.info(responseMSG);
            return responseMSG;
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_user_by_user_email/{userEmail}")
    public ResponseEntity<String> deleteUserByUserEmail(@PathVariable(value = "userEmail") String userEmail) {
        try {
            ResponseEntity responseMSG = userService.deleteOneByUserEmail(userEmail);
            logger.info(responseMSG);
            return responseMSG;
        } catch (Exception ex) {
            String message = ex.getMessage();
            logger.error(message);
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }
    }

}
