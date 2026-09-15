package com.unipi.e16095_assignment.config;

import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String adminUsername = "admin";
        String adminPassword = "admin";

        Users newAdmin = new Users();
        newAdmin.setUsername(adminUsername);
        newAdmin.setPassword(adminPassword); // Replace with hashed password if using BCrypt
        newAdmin.setEmail("admin@system.com");
        newAdmin.setRole(RoleEnum.ADMIN);

        // Prevent creating duplicate admin records on restart
        Optional<Users> existingAdmin = userRepository.findByUsername(adminUsername);
        if (existingAdmin.isPresent()) {
            System.out.println(">>> User already exists. Deleting...");
            userRepository.deleteById(existingAdmin.get().getId());
        }

        userRepository.save(newAdmin);
        System.out.println(">>> Initial admin user created successfully.");
    }
}