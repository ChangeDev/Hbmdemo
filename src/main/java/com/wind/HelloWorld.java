package com.wind;

import com.wind.entity.Message;
import com.wind.entity.Student;
import com.wind.util.HibernateUtil;
import com.wind.util.HsqlDbUtl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @description: Hello world demo for Hibernate;
 * @author: ChangFeng
 * @create: 2018-05-25 14:36
 **/
public class HelloWorld {

    static {
        // 启动hsqldb
        HsqlDbUtl.startHsqlDbServer();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Message message = new Message("Hello world!");
        Long msgId = (Long) session.save(message);
        transaction.commit();

        printAllMessage("Message");

        Session thirdSession = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction thirdTx = thirdSession.beginTransaction();
        message = (Message) thirdSession.get(Message.class, msgId);
        message.setText("new text");
        message.setNextMessage(new Message("Take me to your heart"));
        thirdTx.commit();

        printAllMessage("Message");

        Session forthSession = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction forthTx = forthSession.beginTransaction();
        Student student = new Student.Builder().age(22).gender(1).message(new Message("Wow")).name("dev").build();
        Long userId = (Long) forthSession.save(student);
        forthTx.commit();

        printAllMessage("User");

        HibernateUtil.shutdown();
    }

    public static void printAllMessage(String entityName) {
        Session newSession = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction newTx = newSession.beginTransaction();
        List list = newSession.createQuery("FROM " + entityName).list();
        System.out.println(list.size() + " entities found:");
        list.forEach(entity -> {
            System.out.println(entity);
        });
        newTx.commit();
        // newSession.close();
    }
}