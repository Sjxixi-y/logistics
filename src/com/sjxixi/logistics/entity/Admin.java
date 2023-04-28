package com.sjxixi.logistics.entity;

import java.util.Date;

/**
 * 用户类
 */
public class Admin {
    // 用户编号
    private int id;

    // 用户名称
    private String username;

    // 用户密码
    private String password;

    // 用户电话号码
    private String phone;

    // '用户身份证号'
    private String id_number;

    // 用户姓名
    private String name;

    // 用户性别
    private int sex;

    // 用户出生日期
    private Date birthday;

    // 用户地址
    private String address;

    // 用户权限
    private int permissions;

    // 用户状态
    private int state;

    // 注册时间
    private Date regTime;

    public Admin() {
    }

    public Admin(String username, String password, String phone, String id_number, String name, int sex, Date birthday, String address, int permissions, int state) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.id_number = id_number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.permissions = permissions;
        this.state = state;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin(int id, String username, String password, String phone, String id_number, String name, int sex, Date birthday, String address, int permissions, int state, Date regTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.id_number = id_number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
        this.permissions = permissions;
        this.state = state;
        this.regTime = regTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", id_number='" + id_number + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", permissions=" + permissions +
                ", state=" + state +
                ", regTime=" + regTime +
                '}';
    }
}
