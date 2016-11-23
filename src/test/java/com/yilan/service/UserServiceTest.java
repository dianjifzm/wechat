package com.yilan.service;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016-11-22.
 */
public class UserServiceTest {

    @Test
    public void testAddUser() throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        PlatformTransactionManager txMan = ctx.getBean(PlatformTransactionManager.class);
        TransactionTemplate txTemp = new TransactionTemplate(txMan);
        txTemp.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        txTemp.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txTemp.setTimeout(300);
        txTemp.execute(t ->{
           try {

           }catch (Exception e){

           }
            return null;
        });
        ctx.close();
    }
}