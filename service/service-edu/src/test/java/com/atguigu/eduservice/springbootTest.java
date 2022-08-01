package com.atguigu.eduservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ChenCheng
 * @create 2022-06-29 20:43
 */
@SpringBootTest
public class springbootTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("这是数据库的连接池"+connection);
    }





}
