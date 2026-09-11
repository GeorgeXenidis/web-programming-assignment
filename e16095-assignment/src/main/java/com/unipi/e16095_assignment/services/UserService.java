package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.RegistrationDto;
import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.mappers.UserMapper;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.unipi.e16095_assignment.mappers.UserMapper.responseDtoToUserEntityMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(RegistrationDto registrationDto) {
        Users userToSave = responseDtoToUserEntityMapper(registrationDto);

        userRepository.save(userToSave);
    }

}
