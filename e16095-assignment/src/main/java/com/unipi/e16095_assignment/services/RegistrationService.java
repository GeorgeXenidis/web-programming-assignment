package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.RegistrationDto;
import com.unipi.e16095_assignment.entities.Registrations;
import com.unipi.e16095_assignment.mappers.RegistrationMapper;
import com.unipi.e16095_assignment.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.unipi.e16095_assignment.mappers.RegistrationMapper.registrationDtoToToEntity;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public void registerUser(RegistrationDto registrationDto) {
        Registrations registrationToSave = registrationDtoToToEntity(registrationDto);

        registrationRepository.save(registrationToSave);
    }

    public List<RegistrationDto> getAllPendingRegistrations() {
        return registrationRepository.findAll()
                .stream()
                .map(RegistrationMapper::RegistrationEntityToDto)
                .toList();
    }

    public boolean handleApproval(Long id, String action) {
        registrationRepository.deleteById(id);

        return action.equals("approve");
    }

    public RegistrationDto getRegistrationDtoById(Long id) {
        Optional<Registrations> optionalRegistration = registrationRepository.findById(id);
        if (optionalRegistration.isEmpty()) {
            return new RegistrationDto(null, null, null, null, null);
        }

        Registrations registration = optionalRegistration.get();
        return new RegistrationDto(null, registration.getUsername(), "", registration.getEmail(), null);
    }

}
