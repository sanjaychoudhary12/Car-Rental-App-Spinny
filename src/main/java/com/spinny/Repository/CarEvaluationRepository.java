package com.spinny.Repository;

import com.spinny.entity.CarEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarEvaluationRepository extends JpaRepository<CarEvaluation, Long> {

    @Query("SELECT c FROM CarEvaluation c " +
            "WHERE c.yearOfManufacturing = :yearOfManufacturing " +
            "AND c.minDrivenKm <= :minDriveKm " +
            "AND c.maxDrivenKm >= :maxDriveKm")
    CarEvaluation findCarsByYearAndKmRange (@Param("yearOfManufacturing") int yearOfManufacturing,
                                 @Param("minDriveKm") int minDriveKm ,
                                 @Param("maxDriveKm") int maxDriveKm);

}