package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Tester;

import java.util.List;

public interface TesterDao {
    public int insert(Tester tester);
    public int change(Tester tester);

    public int delete(Tester tester);

    public Tester showAllRecordsById(int testerId);

    public List<Tester> showAllRecords();

}