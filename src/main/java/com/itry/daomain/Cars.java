package com.itry.daomain;

public class Cars {
    //车牌号
    String cno;
    //车型
    String cname;
    //汽车状态，0表示未出借，1表示出借
    int state;
    //汽车备注信息
    String remarks;
    //汽车停靠点，依赖于Park 主键
    String parkposition;

    @Override
    public String toString() {
        return "Cars{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", state=" + state +
                ", remarks='" + remarks + '\'' +
                ", parkposition='" + parkposition + '\'' +
                '}';
    }

    public Cars() {
    }

    public Cars(String cno, String cname, int state, String remarks, String parkposition) {
        this.cno = cno;
        this.cname = cname;
        this.state = state;
        this.remarks = remarks;
        this.parkposition = parkposition;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getParkposition() {
        return parkposition;
    }

    public void setParkposition(String parkposition) {
        this.parkposition = parkposition;
    }



}
