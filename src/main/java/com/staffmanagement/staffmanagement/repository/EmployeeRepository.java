package com.staffmanagement.staffmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.staffmanagement.staffmanagement.models.Employee;


public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    void deleteById(Long id);
}
