package com.itry.service;

import com.itry.daomain.Park;

import java.util.List;

public interface ParkService {

    List<Park> findAll();

    void addParking(Park park);

    void updateAddress(Park park);

    Park findById(String position);

    void deleteById(String position);

}
