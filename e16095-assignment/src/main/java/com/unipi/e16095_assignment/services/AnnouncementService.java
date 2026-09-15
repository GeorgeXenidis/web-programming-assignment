package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.AnnouncementDto;
import com.unipi.e16095_assignment.entities.Announcements;
import com.unipi.e16095_assignment.mappers.AnnouncementMapper;
import com.unipi.e16095_assignment.repositories.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.unipi.e16095_assignment.mappers.AnnouncementMapper.dtoToEntityAnnouncementMapper;

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

    public void newAnnouncement(AnnouncementDto announcementDto) {
        Announcements announcementToSave = dtoToEntityAnnouncementMapper(announcementDto);

        announcementRepository.save(announcementToSave);
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }

}
