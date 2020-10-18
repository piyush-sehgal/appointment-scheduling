package com.pooja.appointment.repo;

import com.pooja.appointment.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserModel, String> {
    UserModel findFirstById(Integer id);
}
