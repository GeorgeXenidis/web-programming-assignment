package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.entities.Registrations;
import com.unipi.e16095_assignment.enums.RoleEnum;

public class RegistrationMapper {

    public static Registrations registrationDtoToToEntity(UserDto userDto) {
        Registrations registrationEntity = new Registrations();

        registrationEntity.setUsername(userDto.getUsername());
        registrationEntity.setPassword(userDto.getPassword());
        registrationEntity.setEmail(userDto.getEmail());
        registrationEntity.setRole(RoleEnum.valueOf(userDto.getRole()));

        return registrationEntity;
    }

    public static UserDto RegistrationEntityToDto(Registrations registrationEntity) {
        UserDto userDto = new UserDto();

        userDto.setId(registrationEntity.getId());
        userDto.setUsername(registrationEntity.getUsername());
        userDto.setPassword("");
        userDto.setEmail(registrationEntity.getEmail());
        userDto.setRole(registrationEntity.getRole().toString());

        return userDto;
    }

}
