package com.project.ncms.controller;

import com.project.ncms.dto.HospitalDTO;
import com.project.ncms.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moh")
@CrossOrigin
public class MohController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping(value = "/hospital", consumes = "application/json", produces = "application/json")
    public void createHospital(@RequestBody HospitalDTO hospitalDTO) {
        hospitalService.addHospital(hospitalDTO);
    }
}
