package com.itry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itry.dao.UserDao;
import com.itry.daomain.User;
import com.itry.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        System.out.println("查找所有");
        return userDao.findAll();
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public Boolean login(User user) {
        System.out.println("用户登录");
        System.out.println(user);
        if (userDao.login(user)==null)
        {
            System.out.println("数据库中无用户");
            return false;
        }
        else
            return true;
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


}
