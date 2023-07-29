package com.staffmanagement.staffmanagement.controllers;

import com.staffmanagement.staffmanagement.repository.UserRepository;
import com.staffmanagement.staffmanagement.services.AdminService;
import com.staffmanagement.staffmanagement.services.UserServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")

public class AdminController {

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    private final AdminService adminService;
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/set-manager/{id}")
    public void setManager(@PathVariable long id){
        adminService.toggleToManager(id);
    }







}
