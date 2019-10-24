package com.pdd.trafficlaws.callcentre;

public class CallCenterModel {
String emergencyservices;
String fireservice;
String number;
int image;

    public CallCenterModel(String emergencyservices, String fireservice, String number,int image) {
        this.emergencyservices = emergencyservices;
        this.fireservice = fireservice;
        this.number = number;
        this.image = image;
    }

    public CallCenterModel() {
    }

    public String getEmergencyservices() {
        return emergencyservices;
    }

    public void setEmergencyservices(String emergencyservices) {
        this.emergencyservices = emergencyservices;
    }

    public String getFireservice() {
        return fireservice;
    }

    public void setFireservice(String fireservice) {
        this.fireservice = fireservice;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
