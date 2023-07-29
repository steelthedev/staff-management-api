package com.staffmanagement.staffmanagement.controllers;

import com.staffmanagement.staffmanagement.models.Role;
import com.staffmanagement.staffmanagement.models.User;
import com.staffmanagement.staffmanagement.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private final UserServices userServices;

    public RegistrationController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "User created successfully")
    public void register(@RequestBody User userRequest){
        userServices.signUp(new User(
                userRequest.getFirstName(),
                userRequest.getFirstName(),
                userRequest.getEmail(),
                userRequest.getUsername(),
                userRequest.getPassword(),
                Role.STAFF
        ));
    };

}
