package com.project.ncms.repository;

import com.project.ncms.dto.HospitalBedDTO;
import com.project.ncms.model.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BedRepository extends JpaRepository<Bed, UUID> {

    @Query(value = "SELECT * FROM bed WHERE status = 'available' AND hospital_id = ?1 LIMIT 1", nativeQuery = true)
    Bed getBedFromHospital(String hospital_id);
}
