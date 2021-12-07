package com.project.ncms.service;

import com.project.ncms.dto.PatientDTO;
import com.project.ncms.model.Patient;
import com.project.ncms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void addPatient(PatientDTO patientDTO) {
        UUID serialNumber = UUID.randomUUID();

        Patient patient = new Patient();
        patient.setSerialNumber(serialNumber);
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setDistrict(patientDTO.getDistrict());
        patient.setxCoordinate(patientDTO.getxCoordinate());
        patient.setyCoordinate(patientDTO.getyCoordinate());
        patient.setContact(patientDTO.getContact());
        patient.setEmail(patientDTO.getEmail());
        patient.setGender(patientDTO.getGender());
        patient.setBirthday(patientDTO.getBirthday());

        patientRepository.save(patient);
    }

    public Patient getPatientById(UUID serialNumber) {
        return patientRepository.findBySerialNumber(serialNumber);
    }
}
