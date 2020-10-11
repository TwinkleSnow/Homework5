package com.homework5.dao;

import com.homework5.bean.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO -- UserDAO
 */
public class UserDAO {
    //MyBatis 核心配置文件
    private static String mbFileStr = "mybatis-config.xml";
    //SqlSessionFactory 是线程安全的
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        //初始化一个输入流
        InputStream inputStream = null;
        try {
            //mybatis 配置文件载入输入流
            inputStream = Resources.getResourceAsStream(mbFileStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过输入流中的配置文件数据构建 SqlSessionFactory 工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 登录
     * 在数据表中按条件查询
     * 调用 selectUser -> mapper
     *
     * @param para_username
     * @param para_password
     * @return
     */
    public boolean login(String para_username, String para_password) {
        //初始化一个 map 用于存放键值对，内容为登录的用户名和密码
        Map<String, String> para_map = new HashMap<String, String>();
        //放入参数
        para_map.put("username", para_username);
        para_map.put("password", para_password);
        //用于进行持久化操作的对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //传参，调用 mapper 中的 sql 语句进行查询操作
        UserEntity userEntity = sqlSession.selectOne("selectUser", para_map);
        //释放 sqlsession 对象
        sqlSession.close();
        if (userEntity != null)
            return true;
        else
            return false;
    }

    /**
     * 返回全部数据
     *
     * @return
     */
    public List<UserEntity> selectUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //将从数据表中取出的值放入 list
        List<UserEntity> list = sqlSession.selectList("allUsers");
        sqlSession.close();
        return list;
    }

    /**
     * 注册
     * 向数据表中插入数据（新用户）
     * 调用 insertUser -> mapper
     *
     * @param para_userEntity
     * @return
     */
    public boolean insertUser(UserEntity para_userEntity) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int flag = sqlSession.insert("insertUser", para_userEntity);
        //持久化操作需要提交
        sqlSession.commit();
        sqlSession.close();
        if (flag > 0)
            return true;
        else
            return false;
    }

    /**
     * 修改
     * 在数据表中修改信息
     * 调用 updateUser -> mapper
     *
     * @param para_userEntity
     * @return
     */
    public boolean updateUser(UserEntity para_userEntity) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int flag = sqlSession.update("updateUser", para_userEntity);
        sqlSession.commit();
        sqlSession.close();
        if (flag > 0)
            return true;
        else
            return false;
    }

    /**
     * 删除
     * 在数据表中删除信息
     * 调用 deleteUser -> mapper
     *
     * @param para_userid
     * @return
     */
    public boolean deleteUser(int para_userid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int flag = sqlSession.delete("deleteUser", para_userid);
        sqlSession.commit();
        sqlSession.close();
        if (flag > 0)
            return true;
        else
            return false;
    }
}
