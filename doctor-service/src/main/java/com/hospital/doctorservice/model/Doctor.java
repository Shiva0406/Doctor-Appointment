package com.hospital.doctorservice.model
;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;
    private String expertise;
    private LocalTime availableFrom;
    private LocalTime availableTo;
    private String contactNumber;
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", expertise=" + expertise
				+ ", availableFrom=" + availableFrom + ", availableTo=" + availableTo + ", contactNumber="
				+ contactNumber + "]";
	}
	public Doctor(Long id, String name, String specialization, String expertise, LocalTime availableFrom,
			LocalTime availableTo, String contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.expertise = expertise;
		this.availableFrom = availableFrom;
		this.availableTo = availableTo;
		this.contactNumber = contactNumber;
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
	public LocalTime getAvailableFrom() {
		return availableFrom;
	}
	public void setAvailableFrom(LocalTime availableFrom) {
		this.availableFrom = availableFrom;
	}
	public LocalTime getAvailableTo() {
		return availableTo;
	}
	public void setAvailableTo(LocalTime availableTo) {
		this.availableTo = availableTo;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

   
}
