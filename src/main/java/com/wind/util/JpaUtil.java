package com.wind.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @description: Util for create EntityManagerFactory
 * @author: ChangFeng
 * @create: 2018-05-25 19:00
 **/
public class JpaUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory createEntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("helloworld");
        return entityManagerFactory;
    }

    public static void shutdown() {
        entityManagerFactory.close();
    }

}