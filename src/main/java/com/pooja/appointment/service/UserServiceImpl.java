package com.pooja.appointment.service;

import com.pooja.appointment.model.UserModel;
import com.pooja.appointment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserModel addUser(UserModel userModel) {
        userModel.setId(10000 + new Random().nextInt(99999));
        return userRepo.save(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserModel getUserDetails(Integer id) {
        return userRepo.findFirstById(id);
    }

    @Override
    public UserModel updateUser(Integer id, UserModel updatedModel) {
        UserModel model = userRepo.findFirstById(id);
        model.setName(updatedModel.getName());
        model.setEmail(updatedModel.getEmail());
        model.setPassword(updatedModel.getPassword());
        return userRepo.save(model);
    }

}
