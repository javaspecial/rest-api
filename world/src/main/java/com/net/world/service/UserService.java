/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.service;

import com.net.world.model.User;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author hp
 */
public interface UserService {

    public List<User> getUserList() throws Exception;

    public ResponseEntity delete(Integer userId) throws Exception;

    public ResponseEntity deleteOneByUserEmail(String userEmail) throws Exception;

    public User save(User user) throws Exception;

    public User update(Integer userId, User user) throws Exception;

    public List<User> findByUserEmail(String userEmail) throws Exception;

    public List<User> findByUserId(Integer userId) throws Exception;

    public List<User> getPaginatedPage(Pageable pageable) throws Exception;

}
