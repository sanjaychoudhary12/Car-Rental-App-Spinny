package com.spinny.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "zone")
public class Zone {

        @Id
        @Column(name = "id", nullable = false)
        private Integer id;

        @Column(name = "area", nullable = false, length = 45)
        private String area;


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

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }


    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

