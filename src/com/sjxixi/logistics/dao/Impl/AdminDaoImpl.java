package com.sjxixi.logistics.dao.Impl;

import com.sjxixi.logistics.dao.IAdminDao;
import com.sjxixi.logistics.entity.Admin;
import com.sjxixi.logistics.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements IAdminDao {
    // 创建一个工具类
    private static final QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());

    /**
     * 添加用户
     *
     * @param a 用户实体类
     * @return 影响行数
     */
    @Override
    public int insert(Admin a) throws SQLException {
        String sql = "INSERT admin(username, password, phone, id_number, name, sex, birthday, address, " +
                "permissions, state) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return qr.update(sql,
                a.getUsername(),
                a.getPassword(),
                a.getPhone(),
                a.getId_number(),
                a.getName(),
                a.getSex(),
                a.getBirthday(),
                a.getAddress(),
                a.getPermissions(),
                a.getState());
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 影响行数
     */
    @Override
    public int delete(Integer id) throws SQLException {
        String sql = "DELETE FROM admin WHERE id=?";
        return qr.update(sql, id);
    }

    /**
     * 修改用户
     *
     * @param a 用户实体类
     * @return 影响行数
     */
    @Override
    public int update(Admin a) throws SQLException {
        String sql = "UPDATE admin SET username=?, password=?, phone=?, id_number=?, name=?," +
                " sex=?, birthday=?, address=?, permissions=?, state=? WHERE id=?";
        return qr.update(sql,
                a.getUsername(),
                a.getPassword(),
                a.getPhone(),
                a.getId_number(),
                a.getName(),
                a.getSex(),
                a.getBirthday(),
                a.getAddress(),
                a.getPermissions(),
                a.getState(),
                a.getId());
    }

    /**
     * 全部查询
     *
     * @return 返回用户集合
     */
    @Override
    public List<Admin> select() throws SQLException {
        String sql = "SELECT id, username, phone, id_number, name, sex, " +
                "birthday, address, permissions, state, regtime FROM admin";
        return qr.query(sql, new BeanListHandler<>(Admin.class));
    }

    /**
     * 模糊查询
     *
     * @param str 模糊查询
     * @return 返回用户集合
     */
    @Override
    public List<Admin> select(String str) throws SQLException {
        String sql = "SELECT id, username, phone, id_number, name, sex, birthday, " +
                "address, permissions, state, regTime FROM admin WHERE username=?";
        return qr.query(sql, new BeanListHandler<>(Admin.class), "'%" + str + "%'");
    }

    /**
     * 根据用户名精准查询
     *
     * @param username 用户名
     * @param i        标识，无具体含义，传入任意 int 类型数字即可
     * @return 用户信息
     */
    @Override
    public Admin select(String username, int i) throws SQLException {
        String sql = "SELECT id, username, phone, id_number, name, sex, birthday, address, permissions, " +
                "state, regTime FROM admin WHERE username=?";
        return qr.query(sql, new BeanHandler<>(Admin.class), username);
    }

    /**
     * 根据用户名、密码查询
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Override
    public Admin select(String username, String password) throws SQLException {
        String sql = "SELECT id, username, phone, id_number, name, sex, birthday, address, " +
                "permissions, state, regTime FROM admin WHERE username=? AND password=?";
        return qr.query(sql, new BeanHandler<>(Admin.class), username, password);
    }
}
