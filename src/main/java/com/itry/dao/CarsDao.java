package com.itry.dao;

import com.itry.daomain.Cars;
import com.itry.daomain.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 车辆curd
 */

@Mapper
public interface CarsDao {

    //查询所有车辆信息
    @Select("select * from car")
    List<Cars> findAll();

    //增加车辆
    @Insert("insert into car(cno,cname,state,remarks,parkposition) values (#{cno},#{cname},#{state},#{remarks},#{parkposition})")
    void addCars(Cars cars);

    //更改车辆
    @Update("update car set cno=#{cno},cname=#{cname},state=#{state},parkposition=#{parkposition} where cno=#{cno}")
    void updateCar(Cars cars);

    //根据车牌查询
    @Select("select * from car where cno=#{cno}")
    Cars findById(String cno);

    //删除车辆信息
    @Delete("delete from car where cno=#{cno}")
    void deleteById(String cno);

    //车辆模糊查询的测试
    @Select("select * from car where cname like concat('%',#{cname},'%')")
    List<Cars> findByLike(@Param("cname") String cname);





}
