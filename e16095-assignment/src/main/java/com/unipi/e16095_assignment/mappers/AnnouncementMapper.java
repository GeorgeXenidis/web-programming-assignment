package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.AnnouncementDto;
import com.unipi.e16095_assignment.entities.Announcements;

public class AnnouncementMapper {

    public static AnnouncementDto entityToDtoAnnouncementMapper(Announcements announcementEntity) {
        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setId(announcementEntity.getId());
        announcementDto.setTitle(announcementEntity.getTitle());
        announcementDto.setContent(announcementEntity.getContent());

        return announcementDto;
    }

    public static Announcements dtoToEntityAnnouncementMapper(AnnouncementDto announcementDto) {
        Announcements announcementEntity = new Announcements();

        announcementEntity.setTitle(announcementDto.getTitle());
        announcementEntity.setContent(announcementDto.getContent());

        return announcementEntity;
    }

}
