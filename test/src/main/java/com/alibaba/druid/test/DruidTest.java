package com.alibaba.druid.test;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhangzhiheng
 * @Date 2019-03-04
 * @Description :
 */
public class DruidTest {

    public static void main(String[] args) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setMaxActive(10);
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxWait(10000);
        druidDataSource.setPassword("root");
        druidDataSource.setUsername("root");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");

        Connection connection = druidDataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM  user limit 0,10");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
        }
        druidDataSource.close();
    }
}
