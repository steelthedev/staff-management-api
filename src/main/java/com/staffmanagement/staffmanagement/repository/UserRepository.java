package com.staffmanagement.staffmanagement.repository;

import com.staffmanagement.staffmanagement.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
