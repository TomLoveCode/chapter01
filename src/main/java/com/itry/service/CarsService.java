package com.itry.service;

import com.itry.daomain.Cars;
import com.itry.daomain.Park;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarsService {

    List<Cars> findAll();

    void addCars(Cars cars);

    void updateCar(Cars cars);

    Cars findById(String cno);

    void deleteById(String cno);

    List<Cars> findByLike(String parkposition);





}
