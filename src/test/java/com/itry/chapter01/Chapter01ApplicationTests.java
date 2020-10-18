package com.itry.chapter01;

import com.itry.daomain.User;
import com.itry.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;


@SpringBootTest
class Chapter01ApplicationTests {
    @Autowired
    private UserService userService;

  //测试数据
    @Test
    void contextLoads() throws SQLException {
        List<User> all = userService.findAll();
        System.out.println(all);

    }
    @Test
    void  sqlTest() throws SQLException {

        User user=new User(11,"hh","hh");
        userService.updateUser(user);
        System.out.println("改变后");
        userService.findAll();
    }


}
