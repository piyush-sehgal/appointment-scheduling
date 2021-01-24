package com.pooja.appointment.service;

import com.pooja.appointment.model.Appointment;
import com.pooja.appointment.model.Patient;
import com.pooja.appointment.repo.AppointmentRepo;
import com.pooja.appointment.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepo appointmentRepo;

    @Autowired
    PatientRepo patientRepo;
    @Override
    public Appointment createAppointment(Appointment appointment) {
        appointment.setId(10000 + new Random().nextInt(99999));
        Integer patientId = appointment.getPatientId();
        Patient patientInfoToUpdate = patientRepo.findFirstById(patientId);
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(appointment);
        patientInfoToUpdate.setAppointments(appointmentList);
        patientRepo.save(patientInfoToUpdate);
        return appointmentRepo.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @Override
    public List<Appointment> getAllAppointmentsOfAPatient(Integer patientId) {
        return appointmentRepo.findAllByPatientId(patientId);
    }

    @Override
    public Appointment rescheduleAppointment(Integer appointmentId, String updatedAppointment) {
        Appointment appointment = new Appointment();
        try{
            appointment = appointmentRepo.findFirstById(appointmentId);
            appointment.setDate(updatedAppointment);
            return appointmentRepo.save(appointment);
        }catch (NullPointerException ex){
            appointment.setMessage("No appointment exists with Id: " + appointmentId);
            return appointment;
        }
    }

    @Override
    public void cancelAppointment(Integer appointmentId) {
        Appointment appointment = appointmentRepo.findFirstById(appointmentId);
        Patient patient = patientRepo.findFirstById(appointment.getPatientId());
        List<Appointment> appointmentList = patient.getAppointments();
        appointmentList.removeIf(appointment1 -> appointment1.getId().equals(appointmentId));
        //if (appointmentList.size() >= 0) {
            patient.setAppointments(appointmentList);
//        } else {
//            patient.setAppointments(null);
//        }
        patientRepo.save(patient);
        appointmentRepo.deleteById(appointmentId);
    }
}
