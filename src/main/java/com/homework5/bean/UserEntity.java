package com.homework5.bean;

/**
 * bean -- UserEntity
 */
public class UserEntity {

    private int userid;         //属性，id
    private String username;    //属性，账号
    private String password;    //属性，密码

    /**
     * 构造函数
     */
    public UserEntity() {
        //
    }

    /**
     * 重载构造函数
     * 3参
     *
     * @param para_userid
     * @param para_username
     * @param para_password
     */
    public UserEntity(int para_userid, String para_username, String para_password) {
        this.userid = para_userid;
        this.username = para_username;
        this.password = para_password;
    }

    /**
     * 重载构造函数
     * 2参
     *
     * @param para_username
     * @param para_password
     */
    public UserEntity(String para_username, String para_password) {
        this.username = para_username;
        this.password = para_password;
    }

    //访问器
    public int getUserid() {
        return userid;
    }

    //访问器
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //访问器
    public String getUsername() {
        return username;
    }

    //访问器
    public void setUsername(String username) {
        this.username = username;
    }

    //访问器
    public String getPassword() {
        return password;
    }

    //访问器
    public void setPassword(String password) {
        this.password = password;
    }
}
