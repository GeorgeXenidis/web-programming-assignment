package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.RegistrationDto;
import com.unipi.e16095_assignment.entities.Registrations;
import com.unipi.e16095_assignment.enums.RoleEnum;

public class RegistrationMapper {

    public static Registrations registrationDtoToToEntity(RegistrationDto registrationDto) {
        Registrations registrationEntity = new Registrations();

        registrationEntity.setUsername(registrationDto.getUsername());
        registrationEntity.setPassword(registrationDto.getPassword());
        registrationEntity.setEmail(registrationDto.getEmail());
        registrationEntity.setRole(RoleEnum.valueOf(registrationDto.getRole()));

        return registrationEntity;
    }

    public static RegistrationDto RegistrationEntityToDto(Registrations registrationEntity) {
        RegistrationDto registrationDto = new RegistrationDto();

        registrationDto.setId(registrationEntity.getId());
        registrationDto.setUsername(registrationEntity.getUsername());
        registrationDto.setPassword("");
        registrationDto.setEmail(registrationEntity.getEmail());
        registrationDto.setRole(registrationEntity.getRole().toString());

        return registrationDto;
    }

}
