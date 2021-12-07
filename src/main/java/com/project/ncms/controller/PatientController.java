package com.project.ncms.controller;

import com.project.ncms.dto.PatientDTO;
import com.project.ncms.model.Patient;
import com.project.ncms.service.PatientRecordService;
import com.project.ncms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRecordService patientRecordService;

    @GetMapping("/all")//patient
    public List<Patient> getAllPatients(){
        List<Patient> lst = patientService.getAllPatients();
        return lst ;
    }

    @GetMapping("/get")//patient/id
    public Patient getPatientById(@RequestParam UUID serialNumber){
        Patient patient = patientService.getPatientById(serialNumber);
        return patient;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity.BodyBuilder addPatient(@RequestBody PatientDTO patientDTO) {
        patientService.addPatient(patientDTO);
        return ResponseEntity.accepted();
    }

    @PostMapping("/admit")
    public ResponseEntity.BodyBuilder createRecord(@RequestParam UUID serialNumber) {

        try {
            patientRecordService.createRecord(serialNumber);
            return (ResponseEntity.BodyBuilder) ResponseEntity.ok("Patient admitted");

        }catch (Exception e){
            return (ResponseEntity.BodyBuilder) ResponseEntity.notFound();
        }

    }
//error code and specific description
    //request and response models
    //properties define outside
    //error handling for bad inputs
}
