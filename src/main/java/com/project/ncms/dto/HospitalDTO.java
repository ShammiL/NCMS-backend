package com.project.ncms.dto;

import java.util.Date;
import java.util.UUID;

public class HospitalDTO {
    private UUID id;
    private String district;
    private int xCoordinate;
    private int yCoordinate;
    private int availableBeds;
    private Date buildOn;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public Date getBuildOn() {
        return buildOn;
    }

    public void setBuildOn(Date buildOn) {
        this.buildOn = buildOn;
    }
}
