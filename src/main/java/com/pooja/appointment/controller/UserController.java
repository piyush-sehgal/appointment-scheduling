package com.pooja.appointment.controller;

import com.pooja.appointment.model.UserModel;
import com.pooja.appointment.repo.UserRepo;
import com.pooja.appointment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @PostMapping("addUser")
    public UserModel addUser(@RequestBody(required = false) UserModel userModel) {
        return userService.addUser(userModel);
    }

    @GetMapping("getAllUsers")
    public List<UserModel> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("getUserDetails")
    public UserModel getUserDetails(@RequestParam(value = "id", required = false) Integer id){
        return userService.getUserDetails(id);
    }

    @PutMapping("updateUser")
    public UserModel updateUser(@RequestParam(value = "id", required = false) Integer id,@RequestBody UserModel updatedModel){
        return userService.updateUser(id, updatedModel);
    }
}
