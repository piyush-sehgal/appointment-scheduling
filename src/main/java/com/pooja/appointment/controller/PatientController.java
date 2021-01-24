package com.pooja.appointment.controller;

import com.pooja.appointment.model.Patient;
import com.pooja.appointment.model.UserModel;
import com.pooja.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("addPatient")
    public Patient addPatient(@RequestBody(required = false) Patient patient){
        return patientService.addPatient(patient);
    }

    @GetMapping("getAllPatients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("getPatientDetails")
    public Patient getPatientDetails(@RequestParam(value = "id", required = false) Integer id){
        return patientService.getPatientDetails(id);
    }

    @PutMapping("updatePatientDetails")
    public Patient updatePatientDetails(@RequestParam(value = "id", required = false) Integer id,@RequestBody Patient updatedPatient){
        return patientService.updatePatientDetails(id, updatedPatient);
    }
}
