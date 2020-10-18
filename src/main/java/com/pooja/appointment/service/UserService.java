package com.pooja.appointment.service;

import com.pooja.appointment.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel userModel);
    List<UserModel> getAllUsers();
    UserModel getUserDetails(Integer id);
    UserModel updateUser(Integer id, UserModel updatedModel);
}
