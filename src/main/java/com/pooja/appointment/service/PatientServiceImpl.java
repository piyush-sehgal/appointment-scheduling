package com.pooja.appointment.service;

import com.pooja.appointment.model.Patient;
import com.pooja.appointment.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Override
    public Patient addPatient(Patient patient) {
        patient.setId(10000 + new Random().nextInt(99999));
        return patientRepo.save(patient);
    }

    @Override
    public Patient getPatientDetails(Integer id) {
        return patientRepo.findFirstById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient updatePatientDetails(Integer id, Patient updatedPatient) {
        Patient patientModel = patientRepo.findFirstById(id);
        patientModel.setName(updatedPatient.getName());
        patientModel.setAge(updatedPatient.getAge());
        patientModel.setAddress(updatedPatient.getAddress());
        patientModel.setGender(updatedPatient.getGender());
        patientModel.setPhone(updatedPatient.getPhone());
        patientModel.setAppointments(updatedPatient.getAppointments());
        return patientRepo.save(patientModel);
    }
}
