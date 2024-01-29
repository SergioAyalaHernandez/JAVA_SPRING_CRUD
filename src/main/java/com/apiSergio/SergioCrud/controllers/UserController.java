package com.apiSergio.SergioCrud.controllers;

import com.apiSergio.SergioCrud.models.UserModel;
import com.apiSergio.SergioCrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/vi/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }
}
