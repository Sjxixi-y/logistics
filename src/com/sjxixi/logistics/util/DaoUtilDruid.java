package com.sjxixi.logistics.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DaoUtilDruid {
    // private static DruidDataSource ds;
    // 连接池对象
    private static DataSource ds;

    // 初始化对象
    static {
        Properties properties = new Properties();
        try {
            // InputStream is = new FileInputStream("src/dp.properties");
            InputStream is = DaoUtilDruid.class.getResourceAsStream("/dp.properties");
            // InputStream is = Class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(is);
            // 创建连接池对象
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接池对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    // 返回一个数据源
    public static DataSource getDataSource() {
        return ds;
    }

    // 释放资源
    public static void close(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null)
                r.close();
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            try {
                if (p != null)
                    p.close();
            } catch (SQLException s) {
                s.printStackTrace();
            } finally {
                try {
                    if (c != null) {
                        c.close();
                    }
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}
