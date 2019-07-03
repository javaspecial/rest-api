/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    public final static String USER_ID = "userId";
    public final static String USER_PASSWORD = "userPassword";
    public final static String USER_EMAIL = "userEmail";
    public final static String USER_ACTIVITY = "userActivity";
    public static final String USER_NAME = "userName";
    public static final String USER_NOTE = "userNote";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USER_ID, unique = true, nullable = false)
    private Integer userId;

    @Column(name = USER_PASSWORD, length = 10)
    private String userPassword;

    @Column(name = USER_EMAIL, unique = true, length = 20)
    private String userEmail;

    @Column(name = USER_ACTIVITY)
    private boolean userActivity;

    @Column(name = USER_NAME, length = 50)
    private String userName;

    @Column(name = USER_NOTE, length = 200)
    private String userNote;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isUserActivity() {
        return userActivity;
    }

    public boolean getUserActivity() {
        return userActivity;
    }

    public void setUserActivity(boolean userActivity) {
        this.userActivity = userActivity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

}
