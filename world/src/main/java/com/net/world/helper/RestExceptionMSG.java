/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.world.helper;

/**
 *
 * @author NETIZEN
 */
public class RestExceptionMSG {

    public static String msg(String msgbody) {
        if (msgbody != null && msgbody.contains("org.hibernate.exception.ConstraintViolationException")) {
            msgbody = "You have entered duplicate email maybe. Please check it and send it again.";
        } else if (msgbody != null && msgbody.contains("org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing")) {
            msgbody = "Please send a user body to perform operation.";
        }
        return msgbody;
    }
}
