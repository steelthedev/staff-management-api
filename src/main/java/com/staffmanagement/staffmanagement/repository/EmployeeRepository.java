package com.staffmanagement.staffmanagement.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.staffmanagement.staffmanagement.models.Employee;


public interface EmployeeRepository extends ListCrudRepository<Employee,Integer>{

}
