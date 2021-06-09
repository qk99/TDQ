package com.igeek.travelSys.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author qiankun
 * @create 2021/6/6
 *
 *
 * 通过DBUtils定义了一套CRUD具体实现模板
 */
public class BasicDao<T>{

    private QueryRunner runner=new QueryRunner();

    //查询单行单列
    public Object getSingleValue(Connection conn,String sql,Object...params) throws SQLException {
        Object value = runner.query(conn, sql, new ScalarHandler<>(), params);
        return  value;
    }

    //查询单个对象
    public T getBean (Connection conn,String sql,Class<T> calzz,Object...params) throws SQLException {
        T t = runner.query(conn, sql, new BeanHandler<>(calzz), params);
        return  t;
    }

    //查询多个对象
    public List<T> getBeanList (Connection conn, String sql, Class<T> calzz, Object...params) throws SQLException {
        List<T>list = runner.query(conn, sql, new BeanListHandler<>(calzz), params);
        return  list;
    }

   //增删改
    public  int updateInfo(Connection conn,String sql,Object...params) throws SQLException {
        int i = runner.update(conn, sql, params);
        return  i;
    }
}
