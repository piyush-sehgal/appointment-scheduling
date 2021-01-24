package com.pooja.appointment.service;

import com.pooja.appointment.model.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    Patient getPatientDetails(Integer id);
    List<Patient> getAllPatients();
    Patient updatePatientDetails(Integer id, Patient updatedPatient);
}
