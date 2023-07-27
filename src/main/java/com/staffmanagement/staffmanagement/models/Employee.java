package com.staffmanagement.staffmanagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record Employee(

    @Id
    Integer id,

    @NotBlank
    @Column(value ="first_name")
    String firstName,

    @NotBlank
    @Column(value ="last_name")
    String lastName,

    @NotBlank
    @Email()
    String email,

    @NotBlank
    @Column(value ="phone_number")
    Long phoneNumber,

    @Column(value="address")
    String address,

    @Column(value = "city")
    String city,

    @Column(value = "zip_code")
    String zipCode

    


) {
    
}
