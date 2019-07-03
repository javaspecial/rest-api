/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.repo;

import com.net.world.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NETIZEN
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    Integer deleteOneByUserEmail(String userEmail); //Custom method auto populated by JpaRepository

    List<User> findDistinctUserByUserNameOrUserEmail(String userName, String userEmail); //Query creation by method naming

    List<User> findByUserNameOrderByUserNameAsc(String userName); //Query creation by method naming

    List<User> findByUser_UserEmail(String userEmail); //property expression like findByAddress_ZipCode(ZipCode zipCode);

    List<User> findTop2ByUserId(Integer userId); // Limiting query

    List<User> findFirst3ByUserId(Integer userId); //Limiting query
}
