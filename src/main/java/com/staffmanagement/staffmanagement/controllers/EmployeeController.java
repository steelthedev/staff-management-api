package com.staffmanagement.staffmanagement.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.staffmanagement.staffmanagement.models.Employee;
import com.staffmanagement.staffmanagement.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeController {

    
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }


    @GetMapping("")
    public Iterable<Employee> findAll(){
        return repository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void add(@Valid @RequestBody Employee employee){
        repository.save(employee);
    }

    @GetMapping("/get/{id}")
    public Employee findById(@PathVariable Long id){
        return repository.findById(id).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
    }

    @PutMapping("/{id}/update")
    public void update(@RequestBody Employee employee, @PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found", null);
        }
        repository.save(employee);
    }
}
