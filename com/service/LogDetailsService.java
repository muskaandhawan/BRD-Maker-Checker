package com.service;

import com.model.entity.CustomerMaster;
import com.model.entity.CustomerTemp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Aspect
@Service
public class LogDetailsService {
    private static final Logger logger = LogManager.getLogger(LogDetailsService.class);

    // temp advice
    @After("execution(* com.model.dao.CustomerTempDAO.saveCustomer(..))")
    public void tempSave(JoinPoint joinPoint){
        String str = "Customer Record inserted in temp table" + joinPoint.getArgs()[0].toString();
//        System.out.println(str);
        logger.info(str);
    }

    @AfterReturning(pointcut = "execution(* com.model.dao.CustomerTempDAO.getById(..))", returning = "customer")
    public void tempGet(JoinPoint joinPoint, CustomerTemp customer) {
        System.out.println("getByID");
        String str = "Fetching details of customer with customer id = " + joinPoint.getArgs()[0];
        logger.info(str);
        if(customer!=null){
            str = "Record fetched: " + customer.toString();
        }
        else {
            str = "Record not found in temp table!";
        }
        logger.info(str);
    }

    @Around("execution(* com.model.dao.CustomerTempDAO.updateCustomer(..))")
    public void tempUpdate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String str = "Updating record: " + proceedingJoinPoint.getArgs()[0].toString();
        logger.info(str);
        proceedingJoinPoint.proceed();
        logger.info("Record updated!");
    }

    @Before("execution(* com.model.dao.CustomerTempDAO.deleteCustomer(..))")
    public void tempDelete(JoinPoint joinPoint) {
        String str = "Deleting record: " + joinPoint.getArgs()[0];
        logger.info(str);
    }

    @AfterReturning(value = "execution(* com.model.dao.CustomerTempDAO.getCustomers(..))", returning = "customers")
    public void tempGetCustomers(JoinPoint joinPoint, List<CustomerTemp> customers){
        String str = "Fetching all customer records from temp table...";
        logger.info(str);
        str = "Records fetched...\n" + customers.toString();
        logger.info(str);
    }

    @Around("execution(* com.model.dao.CustomerTempDAO.saveOrUpdateCustomer(..))")
    public void tempSaveOrUpdateCustomer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String str = "Saving/Updating record: " + proceedingJoinPoint.getArgs()[0].toString();
        logger.info(str);
        proceedingJoinPoint.proceed();
        logger.info("Record saved/updated!");
    }


    // master advice
    @After("execution(* com.model.dao.CustomerMasterDAO.saveCustomer(..))")
    public void masterSave(JoinPoint joinPoint){
        String str = "Customer Record inserted in master table" + joinPoint.getArgs()[0].toString();
//        System.out.println(str);
        logger.info(str);
    }

    @AfterReturning(pointcut = "execution(* com.model.dao.CustomerMasterDAO.getById(..))", returning = "customer")
    public void masterGet(JoinPoint joinPoint, CustomerMaster customer) {
        System.out.println("master get by id");
        String str = "Fetching details of customer with customer id = " + joinPoint.getArgs()[0];
        logger.info(str);
        if(customer!=null){
            str = "Record fetched: " + customer.toString();
        }
        else {
            str = "Record not found in customer master!";
        }
        logger.info(str);
    }

    @Around("execution(* com.model.dao.CustomerMasterDAO.updateCustomer(..))")
    public void masterUpdate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String str = "Updating record: " + proceedingJoinPoint.getArgs()[0].toString();
        logger.info(str);
        proceedingJoinPoint.proceed();
        logger.info("Record updated!");
    }

    @Before("execution(* com.model.dao.CustomerMasterDAO.deleteCustomer(..))")
    public void masterDelete(JoinPoint joinPoint) {
        String str = "Deleting record: " + joinPoint.getArgs()[0];
        logger.info(str);
    }

    @AfterReturning(value = "execution(* com.model.dao.CustomerMasterDAO.getCustomers(..))", returning = "customers")
    public void masterGetCustomers(JoinPoint joinPoint, List<CustomerMaster> customers){
        String str = "Fetching all customer records from master table...";
        logger.info(str);
        str = "Records fetched...\n" + customers.toString();
        logger.info(str);
    }

    @Around("execution(* com.model.dao.CustomerMasterDAO.saveOrUpdateCustomer(..))")
    public void masterSaveOrUpdateCustomer(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String str = "Saving/Updating record: " + proceedingJoinPoint.getArgs()[0].toString();
        logger.info(str);
        proceedingJoinPoint.proceed();
        logger.info("Record saved/updated!");
    }
}
