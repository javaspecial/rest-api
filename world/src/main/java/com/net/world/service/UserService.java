/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.service;

import com.net.world.model.User;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author hp
 */
public interface UserService {

    public List<User> getUserList();

    public ResponseEntity delete(Integer userId);

    public ResponseEntity deleteOneByUserEmail(String userEmail);

    public User save(User user);

    public User update(Integer userId, User user);

    public List<User> findByUserEmail(String userEmail) throws Exception;
    
    public List<User> findByUserId(Integer userId) throws Exception;

}
