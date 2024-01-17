package com.first.springboot.dao;

import com.first.springboot.model.Registered;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterRepository extends CrudRepository<Registered, Integer> {
    @Query("select u from Registered u where u.userName =:n and u.userPassword =:p")
    public List<Registered> findRegisteredUsers(@Param("n") String name, @Param("p") String password);

    @Query("select u from Registered u where u.userName =:n")
    public Registered isUserNameAvailable(@Param("n") String name);
}
