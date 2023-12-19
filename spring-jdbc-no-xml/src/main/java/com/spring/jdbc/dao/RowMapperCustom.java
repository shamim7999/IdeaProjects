package com.spring.jdbc.dao;

public interface RowMapperCustom<T>{
    public T queryRow(String query);
    public T queryById(String query);
}
