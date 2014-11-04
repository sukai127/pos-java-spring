package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.utils.FileUtils;

import java.sql.*;

public class DbUtils {

    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/pos?useUnicode=true&&characterEncoding=utf-8";

    public Connection getConnection(){
        try {
            String user = FileUtils.getValue("user");
            String password = FileUtils.getValue("password");

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("请检查驱动或在pos.properties里面输入正确的用户名和密码");
        }
        return connection;
    }

    public void close(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

}
