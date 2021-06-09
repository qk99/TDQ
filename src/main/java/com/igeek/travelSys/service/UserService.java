package com.igeek.travelSys.service;

import com.igeek.travelSys.dao.UserDao;
import com.igeek.travelSys.entity.User;

import java.sql.SQLException;

/**
 * @author qiankun
 * @create 2021/6/7
 */
public class UserService {

    private UserDao dao=new UserDao();

    //登录
    public boolean login(String username,String password){
        User user=null;
        try {
         user = dao.selectOne(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user!=null? true:false;
    }
}
