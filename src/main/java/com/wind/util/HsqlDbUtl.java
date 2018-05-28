package com.wind.util;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-05-25 19:10
 **/
public class HsqlDbUtl {

    public static void startHsqlDbServer() {
        // 以 server方式启动hsql服务
        String[] args = "--database.0 file:mydb".split(" ");
        org.hsqldb.server.Server.main(args);
    }

}