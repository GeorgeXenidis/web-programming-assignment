package com.unipi.e16095_assignment.repositories;

import com.unipi.e16095_assignment.entities.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registrations, Long> {
}
