package com.igeek.travelSys.dao;

import com.igeek.commutils.DataSourceUtils;
import com.igeek.travelSys.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author qiankun
 * @create 2021/6/7
 */
public class UserDao  extends BasicDao<User> implements IDao<User>{

    //通过用户名和密码查询用户信息
    @Override
    public User selectOne(Object... params) throws SQLException {
        String sql="select * from tab_user where username=?and password=?";
        User user = this.getBean(DataSourceUtils.getConnection(), sql, User.class, params);
        return user;
    }

    @Override
    public List<User> selectAll(Object... params) throws SQLException {
        return null;
    }

    @Override
    public Object selectValue(Object... params) throws SQLException {
        return null;
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Object... params) throws SQLException {
        return 0;
    }

    @Override
    public int insert(User user) throws SQLException {
        return 0;
    }
}
