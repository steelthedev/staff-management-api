package com.staffmanagement.staffmanagement.services;

import com.staffmanagement.staffmanagement.models.User;
import com.staffmanagement.staffmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    public AdminService(UserRepository repository, UserServices userServices) {
        this.userServices = userServices;
    }

    private final UserServices userServices;


    public void toggleToManager(long id){
       userServices.toggleToManager(id);
    }
}
