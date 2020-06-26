package com.li.org.entity;

/*
 *@table: sys_user
 */
public class User {
    private int userId;
    private String userName;
    private String userDesc;
    private String password;
    private String sex;
    private String icon;

    public User(int userId, String userName, String userDesc, String password, String sex, String icon) {
        this.userId = userId;
        this.userName = userName;
        this.userDesc = userDesc;
        this.password = password;
        this.sex = sex;
        this.icon = icon;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
