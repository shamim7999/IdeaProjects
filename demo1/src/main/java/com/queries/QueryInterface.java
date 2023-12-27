package com.queries;

public interface QueryInterface<T> {
    public T queryRow(String query);
    public T queryById(String query);
}
