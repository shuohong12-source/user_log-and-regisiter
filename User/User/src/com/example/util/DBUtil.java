package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private  static  final  String URL="jdbc:mysql://localhost:3306/user_manage?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private  static  final  String USER="root";
    private  static  final  String PASSWORD="20051112";

    public  static Connection getConnection() throws  Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }



}
