package com.itry.daomain;

/**
 * 停车点类
 * 1.停车点编号
 * 2.地址
 */
public class Park {

    String position;
    String address;

    public Park() {


    }

    @Override
    public String toString() {
        return "Park{" +
                "position='" + position + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Park(String position, String address) {
        this.position = position;
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
