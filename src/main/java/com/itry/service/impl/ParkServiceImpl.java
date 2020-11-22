package com.itry.service.impl;

import com.itry.dao.ParkDao;
import com.itry.daomain.Park;
import com.itry.service.ParkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkServiceImpl implements ParkService {

    @Resource
    private ParkDao parkDao;


    @Override
    public List<Park> findAll() {
        System.out.println("查找所有停车点");
        return parkDao.findAll();
    }

    @Override
    public void addParking(Park park) {
        System.out.println("新增停车点");
        parkDao.addParking(park);
    }

    @Override
    public void updateAddress(Park park) {
        System.out.println("修改停车点信息");
        parkDao.updateAddress(park);

    }

    @Override
    public Park findById(String position) {
        return parkDao.findById(position);
    }

    @Override
    public void deleteById(String position) {
        parkDao.deleteById(position);
    }
}
