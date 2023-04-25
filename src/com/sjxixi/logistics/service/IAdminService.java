package com.sjxixi.logistics.service;

import com.sjxixi.logistics.entity.Admin;

import java.util.List;

public interface IAdminService {
    /**
     * 添加用户
     *
     * @param admin 管理员实体类
     * @return 修改行
     */
    int register(Admin admin);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 目标对象
     */
    int delete(Integer id);

    /**
     * 修改用户
     *
     * @param a 用户实体类
     * @return 用户
     */
    int update(Admin a);

    /**
     * 查询全部用户
     *
     * @return 用户对象集合
     */
    List<Admin> qry();

    /**
     * 模糊查询用户
     *
     * @return 用户集合
     */
    List<Admin> qry(String username);

    /**
     * 据用户名精准查询
     *
     * @param username 用户名
     * @param i        无实际意义，只是为了能重载
     * @return 影响行
     */
    Admin qry(String username, int i);

    /**
     * 根据用户名、密码查询
     *
     * @param username 用户名
     * @param password 密码
     * @return 影响行数
     */
    Admin qry(String username, String password);
}
