package com.project.ncms.dto;

import com.project.ncms.model.Types.BedStatus;

import java.util.UUID;

public class HospitalBedDTO {

    private UUID id;
    private UUID hospitalId;
    private int distance;

    public HospitalBedDTO(UUID id, UUID hospitalId, int distance) {
        this.id = id;
        this.hospitalId = hospitalId;
        this.distance = distance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(UUID hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
