package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.RegistrationDto;
import com.unipi.e16095_assignment.entities.Registrations;
import com.unipi.e16095_assignment.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.unipi.e16095_assignment.mappers.RegistrationMapper.registrationDtoToToEntity;

@Service
public class RegisterService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public void registerUser(RegistrationDto registrationDto) {
        Registrations registrationToSave = registrationDtoToToEntity(registrationDto);

        registrationRepository.save(registrationToSave);
    }

}
