package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unipi.e16095_assignment.mappers.UserMapper.dtoToEntityUserMapper;
import static com.unipi.e16095_assignment.mappers.UserMapper.entityToDtoUserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        Users userToSave = dtoToEntityUserMapper(userDto);

        userRepository.save(userToSave);
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> allUsersList = userRepository.findAll()
                .stream()
                .map(userEntity -> entityToDtoUserMapper())
                .toList();
    }

}
