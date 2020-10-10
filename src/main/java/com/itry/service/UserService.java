package com.itry.service;

import com.itry.daomain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByName(String name);

    void save(User user);

    Boolean login(User user);

    User findById(Integer id);

    void deleteUser(Integer id);

}
