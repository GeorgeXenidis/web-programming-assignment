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
        registrationEntity.setRole(RoleEnum.NOT_ASSIGNED);

        return registrationEntity;
    }

}
