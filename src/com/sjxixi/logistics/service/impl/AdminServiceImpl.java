package com.sjxixi.logistics.service.impl;

import com.sjxixi.logistics.dao.IAdminDao;
import com.sjxixi.logistics.dao.Impl.AdminDaoImpl;
import com.sjxixi.logistics.entity.Admin;
import com.sjxixi.logistics.service.IAdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements IAdminService {
    // 创建Dao层对象
    private final static IAdminDao iDao = new AdminDaoImpl();

    /**
     * 添加用户
     *
     * @param admin 管理员实体类
     * @return 修改行 -1 表示过程出错
     */
    @Override
    public int register(Admin admin) {
        try {
            return iDao.insert(admin);
        } catch (SQLException e) {
            System.out.println("添加用户添加用户时出现问题");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 修改行 -1 表示过程出错
     */
    @Override
    public int delete(Integer id) {
        try {
            return iDao.delete(id);
        } catch (SQLException e) {
            System.out.println("删除用户时出现问题");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 修改用户
     *
     * @param a 用户实体类
     * @return 修改行 -1 表示过程出错
     */
    @Override
    public int update(Admin a) {
        try {
            return iDao.update(a);
        } catch (SQLException e) {
            System.out.println("修改用户时出现问题");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询全部用户
     *
     * @return 用户对象集合 null 表示过程出错
     */
    @Override
    public List<Admin> qry() {
        try {
            return iDao.select();
        } catch (SQLException e) {
            System.out.println("查询全部用户时出现问题");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 模糊查询用户
     *
     * @return 用户对象集合 null 表示过程出错
     */
    @Override
    public List<Admin> qry(String str) {
        try {
            iDao.select(str);
        } catch (SQLException e) {
            System.out.println("模糊查询用户时出现问题");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 据用户名精准查询
     *
     * @param username 用户名
     * @param i        无实际意义，只是为了能重载
     * @return 用户对象集合 null 表示过程出错
     */
    @Override
    public Admin qry(String username, int i) {
        try {
            return iDao.select(username, i);
        } catch (SQLException e) {
            System.out.println("据用户名精准查询时出现问题");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户名、密码查询
     *
     * @param username 用户名
     * @param password 密码
     * @return 影响行数
     */
    @Override
    public Admin qry(String username, String password) {
        try {
            return iDao.select(username, password);
        } catch (SQLException e) {
            System.out.println("根据用户名、密码查询时出现问题");
            e.printStackTrace();
        }
        return null;
    }
}
