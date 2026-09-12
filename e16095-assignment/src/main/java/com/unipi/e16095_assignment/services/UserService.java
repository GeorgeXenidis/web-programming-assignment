package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.entities.Users;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.mappers.UserMapper;
import com.unipi.e16095_assignment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        return userRepository.findAll()
                .stream()
                .map(UserMapper::entityToDtoUserMapper)
                .toList();
    }

    public UserDto findUserById(Long id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserMapper::entityToDtoUserMapper).orElseGet(UserDto::new);
    }

    public UserDto updateUser(UserDto newUserDto) {
//        Use findById here in order for EntityManager session to load the existing entity and perform update instead of insertion in DB
        Optional<Users> existingUser = userRepository.findById(newUserDto.getId());
        if (existingUser.isEmpty()) {
            throw new NoSuchElementException("User not found with ID: " + newUserDto.getId());
        }

        Users userToUpdate = updateUserInfo(existingUser.get(), newUserDto);
        Users savedUser = userRepository.save(userToUpdate);

        return entityToDtoUserMapper(savedUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private Users updateUserInfo(Users userToUpdate, UserDto newUserDto) {
//        ID has not to be set as it is already present when fetched from DB

//        Perform null/empty checks in order to configure which values are being requested for update
        if (newUserDto.getUsername() != null && !newUserDto.getUsername().isBlank()) {
            userToUpdate.setUsername(newUserDto.getUsername());
        }
        if (newUserDto.getPassword() != null && !newUserDto.getPassword().isBlank()) {
            userToUpdate.setPassword(newUserDto.getPassword());
        }
        if (newUserDto.getEmail() != null && !newUserDto.getEmail().isBlank()) {
            userToUpdate.setEmail(newUserDto.getEmail());
        }
        if (newUserDto.getRole() != null && !newUserDto.getRole().isBlank() && !newUserDto.getRole().equals(RoleEnum.NOT_ASSIGNED.toString())) {
            userToUpdate.setRole(RoleEnum.valueOf(newUserDto.getRole()));
        }

        return userToUpdate;
    }

}
