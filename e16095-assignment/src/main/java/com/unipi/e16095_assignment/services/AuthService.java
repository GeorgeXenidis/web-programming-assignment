package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.dtos.LoginResponseDto;
import com.unipi.e16095_assignment.entities.Role;
import com.unipi.e16095_assignment.entities.User;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.mappers.LoginMapper;
import com.unipi.e16095_assignment.repositories.RoleRepository;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        Optional<User> optionalUser = userRepository.findByUsername(loginRequestDto.getUsername());
        if (optionalUser.isEmpty()) {
            return new LoginResponseDto(loginRequestDto.getUsername(), null, false);
        }

        User user = optionalUser.get();
        Optional<Role> optionalRole = roleRepository.findById(user.getId());
        if(optionalRole.isPresent()) {}
        if (!user.getPassword().equals(loginRequestDto.getPassword())) {
            return new LoginResponseDto(loginRequestDto.getUsername(), null, false);
        }

        LoginResponseDto
    }

}
