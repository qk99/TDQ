package com.igeek.travelSys.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author qiankun
 * @create 2021/6/6
 *
 *
 * 基础的CRUD规范
 */
public interface IDao<T> {

    T selectOne(Object... params)throws SQLException;

    List<T> selectAll(Object... params)throws SQLException;

    Object selectValue(Object... params)throws SQLException;

    int update(T t) throws SQLException;

    int delete(Object... params) throws SQLException;

    int insert(T t) throws SQLException;
}
