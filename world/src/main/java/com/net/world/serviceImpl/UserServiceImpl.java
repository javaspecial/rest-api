/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.serviceImpl;

import com.net.world.repo.UserRepo;
import com.net.world.model.User;
import com.net.world.service.UserService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Transactional
@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserRepo userRepo;

    @Override
    public List<User> getUserList() {
        return userRepo.findAll();
    }

    @Override
    public User save(User user) throws Exception {
        if (user == null) {
            throw new Exception("Please send a user body to save.");
        }
        return userRepo.save(user);
    }

    @Override
    public ResponseEntity delete(Integer userId) throws Exception {
        if (userId == null) {
            throw new Exception("Please send a user id which user you want to delete.");
        }
        
        List<User> userList = userRepo.findByUserIdLike(userId);
        if (userList == null || userList.isEmpty()) {
            throw new Exception("User is not found by the provided id. User couldnot delete.");
        }
        User user = userRepo.getOne(userId);
        userRepo.delete(user);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @Override
    public User update(Integer userId, User oldUser) throws Exception {
        if (userId == null) {
            throw new Exception("Please send a user id which user you want to update");
        }
        if (oldUser == null) {
            throw new Exception("Please send a user body to update it.");
        }

        User loadedUser = userRepo.getOne(userId);
        if (loadedUser == null) {
            throw new Exception("User is not found by the provided id. User couldnot updated.");
        }
        loadedUser.setUserActivity(oldUser.getUserActivity());
        loadedUser.setUserEmail(oldUser.getUserEmail());
        loadedUser.setUserName(oldUser.getUserName());
        loadedUser.setUserNote(oldUser.getUserNote());
        loadedUser.setUserPassword(oldUser.getUserPassword());
        return userRepo.save(loadedUser);
    }

    @Override
    public ResponseEntity deleteOneByUserEmail(String userEmail) {
        userRepo.deleteOneByUserEmail(userEmail);
        return ResponseEntity.ok("Deleted successfull by user email.");
    }

    @Override
    public List<User> getPaginatedPage(Pageable pageable) throws Exception {
        if (!(pageable instanceof Pageable)) {
            throw new Exception("Pageable is not found. Please send pageable for pagination support");
        }
        pageable = PageRequest.of(0, 3, Sort.by(User.USER_NAME));

        Page<User> page = userRepo.findAll(pageable);
        int number = page.getNumber();
        int elements = page.getNumberOfElements();
        int size = page.getSize();
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        boolean hasNext = page.hasNext();
        boolean hasPrevious = page.hasPrevious();

        List<User> listOfUsers = page.getContent();
        return listOfUsers;
    }

    @Override
    public List<User> findByUserEmail(String userEmail) throws Exception {
        List<User> userList = userRepo.findByUserEmailContaining(userEmail);
        if (userList == null || userList.isEmpty()) {
            throw new Exception("User not found by usages email: " + userEmail);
        }
        return userList;
    }

    @Override
    public List<User> findByUserId(Integer userId) throws Exception {
        List<User> userList = userRepo.findByUserIdLike(userId);
        if (userList == null || userList.isEmpty()) {
            throw new Exception("User not found by usages id: " + userId);
        }
        return userList;
    }

}
