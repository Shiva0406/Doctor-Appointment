package com.hospital.doctorservice.service;

import com.hospital.doctorservice.model.Doctor;
import com.hospital.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        // Custom query method can be added here
        return doctorRepository.findAll(); 
    }

	public Doctor updateDoctor(Long id, Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Doctor registerDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}
}

