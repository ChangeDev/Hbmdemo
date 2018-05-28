package com.wind.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-25 14:55
 **/
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        /**
         *  new Configuration 在classpath根目录下搜索名为hibernate.properties的文件
         *  如果找到了，所有hibernate.*属性都会被加载并添加到Configuration对象中
         *
         *  调用configure()时，Hibernate在classpath的根目录下搜索名为hibernate.cfg.xml的文件
         *  如果无法找到会抛出异常，如果XML配置文件中的设置与之前的设置属性完全相同，将覆盖之前的设置
         *
         *  如果要使用不同的文件，就必须把路径传递给configure()方法
         *  configure("/persistence/auction.cfg.xml")
         *
         *  最后，在创建SessionFactory之前，还可以在Configuration对象中设置额外的配置选项或者映射文件位置
         *  Configuration.setProperty()
         *  Configuration.setProperty().addResource()
         */
        try {
            Configuration configure = new Configuration()
                    .configure();
            sessionFactory = configure.buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}