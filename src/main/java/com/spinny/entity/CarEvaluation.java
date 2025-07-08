package com.spinny.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
    @Table(name = "car_evaluation")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class CarEvaluation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "car_company_name", nullable = false)
        private String carCompanyName;

        @Column(name = "year_of_manufacturing", nullable = false)
        private int yearOfManufacturing;

        @Column(name = "min_driven_km", nullable = false)
        private int minDrivenKm;

        @Column(name = "max_driven_km", nullable = false)
        private int maxDrivenKm;

        @Column(name = "approx_car_amount_min", nullable = false)
        private double approxCarAmountMin;

        @Column(name = "approx_car_amount_max", nullable = false)
        private double approxCarAmountMax;
    }

