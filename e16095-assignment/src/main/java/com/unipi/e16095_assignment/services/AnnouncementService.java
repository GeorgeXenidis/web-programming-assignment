package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.AnnouncementDto;
import com.unipi.e16095_assignment.mappers.AnnouncementMapper;
import com.unipi.e16095_assignment.repositories.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<AnnouncementDto> getAllAnnouncements() {
        return announcementRepository.findAll()
                .stream()
                .map(AnnouncementMapper::entityToDtoAnnouncementMapper)
                .toList();
    }

}
