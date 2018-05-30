package com.wind;

import com.wind.entity.Address;
import com.wind.entity.Person;
import com.wind.entity.User;
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

    public static EntityManagerFactory entityManagerFactory = null;

    static {
        // 启动hsqldb
        HsqlDbUtl.startHsqlDbServer();
        entityManagerFactory = JpaUtil.createEntityManagerFactory();
    }

    public static void main(String[] args) {
        saveUser();
    }

    public static void saveUser() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User();
        user.setLoginName("admin");

        Address homeAddress = new Address();
        homeAddress.setCity("Peking");
        homeAddress.setStreet("ChaoYang");
        homeAddress.setZipCode("001");
        user.setHomeAddress(homeAddress);

        Address billingAddress = new Address();

        billingAddress.setCity("HongKong");
        billingAddress.setStreet("Wanzaimatou");
        billingAddress.setZipCode("002");
        user.setBillingAddress(billingAddress);

        em.persist(user);

        tx.commit();
        em.close();
        queryAll("User");
    }

    public static void savePerson() {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Person person = new Person();
        person.setName("coder");
        em.persist(person);

        tx.commit();
        em.close();

        queryAll("Person");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public static void queryAll(String entityName) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("FROM " + entityName);
        List resultList = query.getResultList();
        resultList.forEach(entity -> {
            System.out.println(entity);
        });
        tx.commit();
        em.close();
    }
}