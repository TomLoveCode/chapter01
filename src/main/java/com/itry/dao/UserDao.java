package com.itry.dao;
import com.itry.daomain.User;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface UserDao {
    //查询所有用户
    @Select("select * from login")
    List<User> findAll();
    //保存信息，注册用户
    @Insert("insert into login(username,password) values(#{username},#{password})")
    void save(com.itry.daomain.User user);
    //根据用户登录
    @Select("select * from login where username=#{username} and password=#{password}")
   User login(com.itry.daomain.User user);
    //根据用户名查找
    @Select("select * from login where username=#{name}")
    User findByName(String name);
    //根据id查找
    @Select("select * from login where id=#{id}")
    User findById(Integer id);

    @Delete("delete from login where id=#{id}")
    void deleteUser(Integer id);

    @Update("update login set username=#{username}, password=#{password} where id=#{id}")
    void updateUser(User user);


    //测试无条件的查询分页








}
