package com.spring.jdbc.dao;
import com.spring.jdbc.entity.Tester;

import java.sql.ResultSet;
import java.util.List;

public interface RowMapperCustom<T>{
    public T queryRow(String query);
    public T queryById(String query);
}
