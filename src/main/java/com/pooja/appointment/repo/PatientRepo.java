package com.pooja.appointment.repo;

import com.pooja.appointment.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepo extends MongoRepository<Patient, Integer> {
    Patient findFirstById(Integer id);
}
