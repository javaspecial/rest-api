/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neti.world.aspect;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

    final private Logger logger = LogManager.getLogger(UserServiceAspect.class);

    @Before("execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Before advice: " + joinPoint.getSignature().getName());
        logger.info("Arguments passes: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("After advice: " + joinPoint.getSignature().getName());
        logger.info("Arguments passes: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(pointcut = "execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))", throwing = "ex")
    public void afterThrowingAdvice(Exception ex) throws Throwable {
        logger.info("After throwing advice: " + ex.getMessage());
    }

    @AfterReturning(value = "execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("After returning advice: " + joinPoint.getSignature().getName() + ".Result: " + result);
    }

//    @Around("execution(* com.net.world.serviceImpl.UserServiceImpl.*(..))")
//    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        try {
//            joinPoint.proceed();
//        } finally {
//
//        }
//        long timeTaken = System.currentTimeMillis() - startTime;
//        logger.info("Around advice: " + joinPoint.getSignature().getName() + ".ExecutionTime: " + timeTaken);
//    }

}
