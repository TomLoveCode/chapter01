package com.itry.service.impl;

import com.itry.dao.CarsDao;
import com.itry.daomain.Cars;
import com.itry.service.CarsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CarsServiceImpl  implements CarsService {
    @Resource
    CarsDao carsDao;
    @Override
    public List<Cars> findAll() {
        return carsDao.findAll();
    }

    @Override
    public void addCars(Cars cars) {
    carsDao.addCars(cars);
    }

    @Override
    public void updateCar(Cars cars) {
    carsDao.updateCar(cars);
    }

    @Override
    public Cars findById(String cno) {
        return carsDao.findById(cno);
    }

    @Override
    public void deleteById(String cno) {
     carsDao.deleteById(cno);
    }

    @Override
    public List<Cars> findByLike(String cname) {
        System.out.println("模糊查询");
        return carsDao.findByLike(cname);
    }


}
