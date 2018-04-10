package com.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/*
列名	类型	长度	备注	关系
Id	int		账号	PK
name	varchar	12	姓名
sex	char	1	性别
email	varchar	20	邮箱
user_level	int		用户等级
Phone_num	varchar	12	用户号码
pwd	Varchar	10	用户密码	*/
@Table(name = "User")
public class User implements Serializable{
    public User() { }

    public User(String username, String password, String sex, String phone, int userLevel, String email) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.userLevel = userLevel;
        this.email = email;
    }
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "sex")
    private String sex;
    @Column(name = "phone")
    private String phone;
    @Column(name = "userLevel")
    private int userLevel;
    @Column(name = "email")
    private String email;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override public String toString() {
        return "User{" + "username='" + username + '\'' + ", password='" + password +
                '\'' +", sex='" + sex+ ", phone='" + phone+", email='" + email+'}';
    }
}
