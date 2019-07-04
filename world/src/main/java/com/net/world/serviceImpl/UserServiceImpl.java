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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public ResponseEntity delete(Integer userId) {
        try {
            User user = userRepo.getOne(userId);
            userRepo.delete(user);
            return ResponseEntity.ok("Deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.ok("Exception occured!" + e.getMessage());
        }
    }

    @Override
    public User update(Integer userId, User oldUser) {
        User loadedUser = userRepo.getOne(userId);

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

    public Page<User> findUserByPageSize(Integer pageSize) {
        return userRepo.findAll(PageRequest.of(1, pageSize, Sort.by(Sort.Order.asc(User.USER_NAME))));
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
