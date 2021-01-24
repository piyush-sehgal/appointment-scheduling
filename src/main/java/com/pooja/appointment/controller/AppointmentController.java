package com.pooja.appointment.controller;

import com.pooja.appointment.model.Appointment;
import com.pooja.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("createAppointment")
    public Appointment createAppointment(
            @RequestBody(required = false)Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("getAllAppointments")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("getAllAppointmentsOfAPatient")
    public List<Appointment> getAllAppointmentsOfAPatient(@RequestParam(value = "patientId", required = false)Integer patientId){
        return appointmentService.getAllAppointmentsOfAPatient(patientId);
    }

    @PutMapping("rescheduleAppointment")
    public Appointment rescheduleAppointment(@RequestParam(value = "appointmentId", required = false)Integer appointmentId, @RequestParam(value = "date", required = false) String rescheduleDate){
        return appointmentService.rescheduleAppointment(appointmentId, rescheduleDate);
    }

    @DeleteMapping("cancelAppointment")
    public void cancelAppointment(@RequestParam(value = "appointmentId", required = false)Integer appointmentId){
        appointmentService.cancelAppointment(appointmentId);
    }
}
