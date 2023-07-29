package com.staffmanagement.staffmanagement.services;

import com.staffmanagement.staffmanagement.models.SecurityUser;
import com.staffmanagement.staffmanagement.models.User;
import com.staffmanagement.staffmanagement.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {


    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UserServices(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;

        this.encoder = encoder;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public boolean usernameExists(String username){
        return repository.findByUsername(username).isPresent();
    }

    public boolean emailExists(String email){
        return repository.findByEmail(email).isPresent();
    }

    public String signUp(User user){

        if (usernameExists(user.getUsername())){
            throw new  IllegalStateException("User with this username already exists");
        }
        if (emailExists(user.getEmail())){
            throw new  IllegalStateException("User with this email already exists");
        }

        String encodedPassword = encoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        repository.save(user);

        return "done";
    }
}
