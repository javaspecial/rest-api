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
    private UserRepo userDao;

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public ResponseEntity delete(Integer userId) {
        try {
            User user = userDao.getOne(userId);
            userDao.delete(user);
            return ResponseEntity.ok("Deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.ok("Exception occured!" + e.getMessage());
        }
    }

    @Override
    public User update(Integer userId, User oldUser) {
        User loadedUser = userDao.getOne(userId);

        loadedUser.setUserActivity(oldUser.getUserActivity());
        loadedUser.setUserEmail(oldUser.getUserEmail());
        loadedUser.setUserName(oldUser.getUserName());
        loadedUser.setUserNote(oldUser.getUserNote());
        loadedUser.setUserPassword(oldUser.getUserPassword());
        return userDao.save(loadedUser);
    }

}
