package com.spinny.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "agent")
public class Agent {


        @Id
        @Column(name = "id", nullable = false)
        private Integer id;

        @Column(name = "Name", nullable = false, length = 45)
        private String name;

        @Column(name = "Email", nullable = false, length = 128)
        private String email;

        @Column(name = "Mobile", nullable = false, length = 10)
        private String mobile;

        // Constructors
        public Agent() {
        }

        public Agent(Integer id, String name, String email, String mobile) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.mobile = mobile;
        }

        // Getters and Setters

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        // toString
        @Override
        public String toString() {
            return "Agent{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", mobile='" + mobile + '\'' +
                    '}';
        }
    }


//Images management is also done in this project via aws s3 which is missing make it on your own.