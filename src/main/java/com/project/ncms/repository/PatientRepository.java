package com.project.ncms.repository;

import com.project.ncms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findBySerialNumber(UUID serialNumber);
}
