/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.repo;

import com.net.world.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NETIZEN
 */
public interface UserRepo extends JpaRepository<User, Integer> {
      User  findByName(String name);
}
