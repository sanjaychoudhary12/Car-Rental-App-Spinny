package com.spinny.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "schedule_visit")
public class ScheduleVisit {

    @Id
   //@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_company_name", nullable = false, length = 45)
    private String carCompanyName;

    @Column(name = "year_of_manufacturing", nullable = false)
    private Integer yearOfManufacturing;

    @Column(name = "min_driven_km", nullable = false, length = 45)
    private String minDrivenKm;

    @Column(name = "max_driven_km", nullable = false, length = 45)
    private String maxDrivenKm;

    @Column(name = "approx_car_amount_min", nullable = false)
    private Integer approxCarAmountMin;

    @Column(name = "approx_car_amount_max", nullable = false)
    private Integer approxCarAmountMax;

    @Column(name = "car_number", nullable = false)
    private Integer carNumber;

    @Column(name = "location", nullable = false, length = 45)
    private String location;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "mobile", nullable = false, length = 45)
    private String mobile;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    // Constructors
    public ScheduleVisit() {
    }

    public ScheduleVisit(Integer id, String carCompanyName, Integer yearOfManufacturing, String minDrivenKm,
                         String maxDrivenKm, Integer approxCarAmountMin, Integer approxCarAmountMax,
                         Integer carNumber, String location, String name, String mobile, String email, Agent agent) {
        this.id = id;
        this.carCompanyName = carCompanyName;
        this.yearOfManufacturing = yearOfManufacturing;
        this.minDrivenKm = minDrivenKm;
        this.maxDrivenKm = maxDrivenKm;
        this.approxCarAmountMin = approxCarAmountMin;
        this.approxCarAmountMax = approxCarAmountMax;
        this.carNumber = carNumber;
        this.location = location;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.agent = agent;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarCompanyName() {
        return carCompanyName;
    }

    public void setCarCompanyName(String carCompanyName) {
        this.carCompanyName = carCompanyName;
    }

    public Integer getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(Integer yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public String getMinDrivenKm() {
        return minDrivenKm;
    }

    public void setMinDrivenKm(String minDrivenKm) {
        this.minDrivenKm = minDrivenKm;
    }

    public String getMaxDrivenKm() {
        return maxDrivenKm;
    }

    public void setMaxDrivenKm(String maxDrivenKm) {
        this.maxDrivenKm = maxDrivenKm;
    }

    public Integer getApproxCarAmountMin() {
        return approxCarAmountMin;
    }

    public void setApproxCarAmountMin(Integer approxCarAmountMin) {
        this.approxCarAmountMin = approxCarAmountMin;
    }

    public Integer getApproxCarAmountMax() {
        return approxCarAmountMax;
    }

    public void setApproxCarAmountMax(Integer approxCarAmountMax) {
        this.approxCarAmountMax = approxCarAmountMax;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }


}

