package com.unipi.e16095_assignment.config;

import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        // Prevent creating duplicate admin records on restart
        if (userRepository.findByUsername(adminUsername).isEmpty()) {
            Users admin = new Users();
            admin.setUsername(adminUsername);
            admin.setPassword(adminPassword); // Replace with hashed password if using BCrypt
            admin.setEmail("admin@system.com");
            admin.setRole(RoleEnum.ADMIN);

            userRepository.save(admin);
            System.out.println(">>> Initial admin user created successfully.");
        } else {
            System.out.println(">>> User already exists.");
        }
    }
}