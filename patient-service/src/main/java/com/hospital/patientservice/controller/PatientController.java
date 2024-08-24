package com.hospital.patientservice.controller;

import com.hospital.patientservice.model.Patient;
import com.hospital.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        Patient registeredPatient = patientService.registerPatient(patient);
        return ResponseEntity.ok(registeredPatient);
    }

    @PostMapping("/login")
    public ResponseEntity<Patient> loginPatient(@RequestBody Patient patient) {
        Patient loggedInPatient = patientService.loginPatient(patient.getEmail(), patient.getPassword());
        return ResponseEntity.ok(loggedInPatient);
    }
}
