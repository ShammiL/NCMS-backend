package com.project.ncms.service;

import com.project.ncms.dto.HospitalBedDTO;
import com.project.ncms.model.Bed;
import com.project.ncms.model.Hospital;
import com.project.ncms.model.Patient;
import com.project.ncms.model.PatientRecord;
import com.project.ncms.model.Types.PatientStatus;
import com.project.ncms.repository.BedRepository;
import com.project.ncms.repository.HospitalRepository;
import com.project.ncms.repository.PatientRecordRepository;
import com.project.ncms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PatientRecordService {
HospitalService hospitalService;
    @Autowired
    BedRepository bedRepository;
    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientRecordRepository patientRecordRepository;

    public void createRecord(UUID serialNumber) throws Exception {
        Patient patient = null;
        try {
            patient = patientRepository.findBySerialNumber(serialNumber);
        }catch (NullPointerException e){
            throw new Exception(e.getMessage());
        }
        Hospital hospital = hospitalRepository.findNearestHospital(patient.getxCoordinate(), patient.getyCoordinate());
        System.out.println(hospital.getId());
        Bed bed = bedRepository.getBedFromHospital(hospital.getId().toString());
        System.out.println(bed.getId());
        UUID id = UUID.randomUUID();
        Date admitDate = new Date();
        PatientRecord patientRecord = new PatientRecord();
        patientRecord.setId(id);
        patientRecord.setPatient(patient);
        patientRecord.setHospital(hospital);
        patientRecord.setStatus(PatientStatus.admitted);
        patientRecord.setBed(bed);
        patientRecord.setAdmitDate(admitDate);

        patientRecordRepository.save(patientRecord);
    }
    //get all patient records
    //get patient current record
    //get all current records
    //get current records of hospital
}
