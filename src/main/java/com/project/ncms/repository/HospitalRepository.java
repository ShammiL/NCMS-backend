package com.project.ncms.repository;

import com.project.ncms.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface HospitalRepository extends JpaRepository<Hospital, UUID> {
    @Query(value = "SELECT id, available_beds, build_on, district, x_coordinate, y_coordinate, power((x_coordinate - ?1),2) + power((y_coordinate - ?2),2) as distance FROM hospital ORDER BY distance LIMIT 1", nativeQuery = true)
    Hospital findNearestHospital(int x_coordinate, int y_coordinate);

}
