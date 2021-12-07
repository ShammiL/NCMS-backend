package com.project.ncms.model;

import com.project.ncms.model.Types.PatientLevel;
import com.project.ncms.model.Types.PatientStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "patientRecord")
public class PatientRecord {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade= CascadeType.ALL)
    @JoinColumn(name = "serialNumber", nullable = false, referencedColumnName = "serialNumber")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade= CascadeType.ALL)
    @JoinColumn(name = "hospitalId", nullable = true, referencedColumnName = "id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.EAGER, optional = true,cascade= CascadeType.ALL)
    @JoinColumn(name = "bedId", nullable = true, referencedColumnName = "id")
    private Bed bed;

    @ManyToOne(fetch = FetchType.EAGER, optional = true,cascade= CascadeType.ALL)
    @JoinColumn(name = "doctorId", nullable = true, referencedColumnName = "id")
    private Doctor doctor;

    @Column(name = "admitDate", nullable = false)
    private Date admitDate;

    @Column(name = "dischargeDate", nullable = true)
    private Date dischargeDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PatientStatus status;

    @Column(name = "level", nullable = true)
    @Enumerated(EnumType.STRING)
    private PatientLevel level;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public PatientLevel getLevel() {
        return level;
    }

    public void setLevel(PatientLevel level) {
        this.level = level;
    }
}
