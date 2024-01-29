package com.apiSergio.SergioCrud.controllers;

import com.apiSergio.SergioCrud.models.UserModel;
import com.apiSergio.SergioCrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("/save")
    public UserModel saveUsers(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/update/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){

        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User whit id " +id + "delete";
        }else{
            return "Not delete, no find id " + id;
        }
    }

}
