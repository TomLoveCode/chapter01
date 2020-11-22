package com.itry.dao;

import com.itry.daomain.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkDao {

    //查询所用的停车点
    @Select("select * from park")
    List<Park> findAll();

    //增加停车点
    @Insert("insert into park(position,address) values (#{position},#{address})")
    void addParking(Park park);

    //更改停车点信息
    @Update("update park set address=#{address} where position=#{position}")
    void updateAddress(Park park);

    //根据停车点id查询
    @Select("select * from park where position=#{position}")
    Park findById(String position);

    //删除停车点
    @Delete("delete from park where position=#{position}")
    void deleteById(String position);



}
