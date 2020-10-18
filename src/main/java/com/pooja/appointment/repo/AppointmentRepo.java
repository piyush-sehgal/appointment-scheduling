package com.pooja.appointment.repo;

import com.pooja.appointment.model.Appointment;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepo extends MongoRepository<Appointment,Integer> {
        Appointment findFirstById(int id);
        List<Appointment> findAllByPatientId(Integer patientId);

        @Override
        void deleteById(Integer id);
}
