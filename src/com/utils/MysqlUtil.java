package com.utils;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
* 数据库工具类
*
* */
public class MysqlUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/mall?verifyServerCertificate=true&useSSL=false&requireSSL=false";
    private String dbUserName="root";
    private String dbPassword="123456";
    private String jdbcName="com.mysql.jdbc.Driver";
    private Connection con;

    /**
  * 获取数据库连接
  * @return
  * @throws Exception
  **/
    public Connection getCon()throws Exception{
        Class.forName(jdbcName);
        Connection Con= DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return Con;

    }

    /**
    * 关闭数据库
    * @param con
     * @throws  Exception
    **/
    public void closeCon(Connection con)throws Exception{
        this.con = con;
        if(con!=null){
            con.close();
        }
    }
    public static void main(String[] args) {
        MysqlUtil dbUtil=new MysqlUtil();
        try {
            dbUtil.getCon();
            System.out.println("connect success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
