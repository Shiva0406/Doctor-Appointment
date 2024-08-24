package com.hospital.doctorservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private String expertise;
    private String availableFrom;  // Example format: "YYYY-MM-DD"
    private String availableTo;    // Example format: "YYYY-MM-DD"

    // Constructors
    public Doctor() {
    }

    public Doctor(Long id, String name, String specialization, String expertise, String availableFrom, String availableTo) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.expertise = expertise;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(String availableTo) {
        this.availableTo = availableTo;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", expertise='" + expertise + '\'' +
                ", availableFrom='" + availableFrom + '\'' +
                ", availableTo='" + availableTo + '\'' +
                '}';
    }
}
