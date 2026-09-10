package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.RegisterUserDto;
import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.unipi.e16095_assignment.mappers.UserMapper.responseDtoToUserEntityMapper;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(RegisterUserDto registerUserDto) {
        Users userToSave = responseDtoToUserEntityMapper(registerUserDto);
        userToSave.setRole(RoleEnum.NOT_ASSIGNED);

        userRepository.save(userToSave);
    }

}
