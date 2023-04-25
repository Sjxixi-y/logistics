package com.sjxixi.logistics.dao;

import com.sjxixi.logistics.entity.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public interface IAdminDao {
    /**
     * 添加用户
     *
     * @param a 用户实体类
     * @return 影响行数
     */
    int insert(Admin a) throws SQLException;

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 影响行数
     */
    int delete(Integer id) throws SQLException;

    /**
     * 修改用户
     *
     * @param a 用户实体类
     * @return 影响行数
     */
    int update(Admin a) throws SQLException;

    /**
     * 全部查询
     *
     * @return 返回用户集合
     */
    List<Admin> select() throws SQLException;

    /**
     * 模糊查询
     *
     * @param str 模糊查询
     * @return 返回用户集合
     */
    List<Admin> select(String str) throws SQLException;

    /**
     * 根据用户名精准查询
     *
     * @param str 用户名
     * @param i   标识，无具体含义，传入任意 int 类型数字即可
     * @return 用户信息
     */
    Admin select(String str, int i) throws SQLException;

    /**
     * 根据用户名、密码查询
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    Admin select(String username, String password) throws SQLException;
}
