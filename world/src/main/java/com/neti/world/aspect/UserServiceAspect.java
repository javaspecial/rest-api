/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neti.world.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Md. Shadath on behalf of Netizen IT Limited.
 */
@Aspect
@Configuration
public class UserServiceAspect {

    @Before("execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before advice: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After advice: " + joinPoint.getSignature().getName());
    }
}
