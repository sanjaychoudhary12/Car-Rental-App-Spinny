package com.spinny.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "car_actual_detail", schema = "mydb")
public class CarActualDetail {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "car_number", nullable = false, length = 45)
        private String carNumber;

        @Column(name = "make_year", nullable = false, length = 45)
        private String makeYear;

        @Column(name = "model", nullable = false, length = 45)
        private String model;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Column(name = "offered_price", nullable = false, length = 45)
    private int offered_price;



    @ManyToOne
        @JoinColumn(name = "agent_id")
        private Agent agent;



        // Getters and Setters

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        public String getMakeYear() {
            return makeYear;
        }

        public void setMakeYear(String makeYear) {
            this.makeYear = makeYear;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Agent getAgent() {
            return agent;
        }

        public void setAgent(Agent agent) {
            this.agent = agent;
        }


    public int getOffered_price() {
        return offered_price;
    }

    public void setOffered_price(int offered_price) {
        this.offered_price = offered_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    }


