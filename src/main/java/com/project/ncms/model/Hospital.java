package com.project.ncms.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "hospital")
public class Hospital {

        @Id
        @Type(type = "org.hibernate.type.UUIDCharType")
        private UUID id;

        @Column(name = "xCoordinate", nullable = false)
        private int xCoordinate;

        @Column(name = "yCoordinate", nullable = false)
        private int yCoordinate;

        @Column(name = "district", nullable = false)
        private String district;

        @Column(name = "availableBeds", nullable = false)
        private int availableBeds;

        @Column(name = "buildOn", nullable = false)
        private Date buildOn;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
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

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
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
