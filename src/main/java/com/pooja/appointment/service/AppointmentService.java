package com.pooja.appointment.service;

import com.pooja.appointment.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    List<Appointment> getAllAppointmentsOfAPatient(Integer patientId);
    Appointment rescheduleAppointment(Integer appointmentId, String updatedTime);
    void cancelAppointment(Integer appointmentId);
}
