package com.first.springboot.dao;

import com.first.springboot.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
    public List<User> findAllByCityInOrderByName(List<String> cities);
    @Query("select u from User u where u.name =:n and u.city =:c")
    public List<User> getAllUser(@Param("n") String name, @Param("c") String city);

    @Query(value = "select u from User u where u.name = ?1 and u.city = ?2", nativeQuery = false)
    public List<User> getAllUserByHqlAnotherWay(String name, String city);

    @Query(value = "select * from user u where u.name =:name and u.city =:city", nativeQuery = true)
    public List<User> getAllUserByNativeQuery(@Param("name") String name, @Param("city") String city);
}
