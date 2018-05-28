package com.wind;

import com.wind.entity.Person;
import com.wind.util.HsqlDbUtl;
import com.wind.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @description: Hello world for JPA
 * @author: ChangFeng
 * @create: 2018-05-25 18:58
 **/
public class HelloWorldJpa {

    static {
        // 启动hsqldb
        HsqlDbUtl.startHsqlDbServer();
    }

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = JpaUtil.createEntityManagerFactory();
        EntityManager em1 = entityManagerFactory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Person person = new Person();
        person.setName("coder");
        em1.persist(person);

        tx1.commit();
        em1.close();

        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();
        Query query = em2.createQuery("FROM Person");
        List resultList = query.getResultList();
        resultList.forEach(entity -> {
            System.out.println(entity);
        });
        tx2.commit();
        em2.close();
    }
}