package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.mappers.UserMapper;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.unipi.e16095_assignment.mappers.UserMapper.dtoToEntityUserMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        Users userToSave = dtoToEntityUserMapper(userDto);

        userRepository.save(userToSave);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::entityToDtoUserMapper)
                .toList();
    }

    public UserDto findUserById(Long id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserMapper::entityToDtoUserMapper).orElseGet(UserDto::new);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
