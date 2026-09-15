package com.unipi.e16095_assignment.repositories;

import com.unipi.e16095_assignment.entities.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcements, Long> {
}
