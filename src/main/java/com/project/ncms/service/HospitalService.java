package com.project.ncms.service;

import com.project.ncms.dto.HospitalBedDTO;
import com.project.ncms.dto.HospitalDTO;
import com.project.ncms.model.Bed;
import com.project.ncms.model.Hospital;
import com.project.ncms.model.Types.BedStatus;
import com.project.ncms.repository.BedRepository;
import com.project.ncms.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private BedRepository bedRepository;

    @Transactional
    public void addHospital(HospitalDTO hospitalDTO){
        UUID id = UUID.randomUUID();
        int bedCount = 10;
        Date builtOn = new Date();
        List<Bed> beds = new ArrayList<>();

        Hospital hospital = new Hospital();
        hospital.setId(id);
        hospital.setDistrict(hospitalDTO.getDistrict());
        hospital.setxCoordinate(hospitalDTO.getxCoordinate());
        hospital.setyCoordinate(hospitalDTO.getyCoordinate());
        hospital.setAvailableBeds(bedCount);
        hospital.setBuildOn(builtOn);

        hospitalRepository.save(hospital);

        for (int i = 0; i<10; i++){
            Bed bed = new Bed();
            UUID bedId = UUID.randomUUID();

            bed.setId(bedId);
            bed.setHospital(hospital);
            bed.setStatus(BedStatus.available);
            beds.add(bed);
        }
        bedRepository.saveAll(beds);

    }

//    public HospitalBedDTO getNearestBed(int x_coordinate, int y_coordinate) {
//        System.out.println(bedRepository.findNearestHospital(x_coordinate, y_coordinate));
//        return bedRepository.findNearestHospital(x_coordinate, y_coordinate);
//    }

}
