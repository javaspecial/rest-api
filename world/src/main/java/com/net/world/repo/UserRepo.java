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

    public Integer deleteOneByUserEmail(String userEmail); //Custom method auto populated by JpaRepository

    public List<User> findDistinctUserByUserNameOrUserEmail(String userName, String userEmail); //Query creation by method naming

    public List<User> findByUserNameOrderByUserNameAsc(String userName); //Query creation by method naming

    public List<User> findTop2ByUserId(Integer userId); // Limiting query

    public List<User> findFirst3ByUserId(Integer userId); //Limiting query

    public List<User> findByUserEmailContaining(String userName); //Searching criteria with like operation

    public List<User> findByUserIdLike(Integer userId); //Searching criteria with like operation
}
