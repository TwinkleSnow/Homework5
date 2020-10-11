package com.homework5.action;

import com.homework5.bean.UserEntity;
import com.homework5.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action -- UserAction
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
    private int userid;         //属性，id
    private String username;    //属性，账号
    private String password;    //属性，密码


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


    //初始化 userDAO 对象
    UserDAO userDAO = new UserDAO();

    /**
     * login.action
     *
     * @return
     */
    public String login() {
        boolean flag = userDAO.login(username, password);
        if (flag)
            return "loginSuccess";
        else
            return "loginFailure";

    }

    /**
     * register.action
     *
     * @return
     */
    public String register() {
        UserEntity userEntity = new UserEntity(userid, username, password);
        boolean flag = userDAO.insertUser(userEntity);
        if (flag)
            return "registerSuccess";
        else
            return "registerFailure";
    }

    /**
     * userupdate.action
     *
     * @return
     */
    public String userupdate() {
        UserEntity userEntity = new UserEntity(userid, username, password);
        boolean flag = userDAO.updateUser(userEntity);
        if (flag)
            return "updateSuccess";
        else
            return "updateFailure";
    }

    /**
     * userdelete.action
     *
     * @return
     */
    public String userdelete() {
        boolean flag = userDAO.deleteUser(userid);
        if (flag)
            return "deleteSuccess";
        else
            return "deleteFailure";
    }
}
