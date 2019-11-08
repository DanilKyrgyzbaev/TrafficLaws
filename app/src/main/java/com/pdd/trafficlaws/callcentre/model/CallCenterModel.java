package com.pdd.trafficlaws.callcentre.model;

public class CallCenterModel {

    private String number;
    private  String name;
    private  long id;

    public CallCenterModel() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}