package com.guestbook;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuestbookService {

    @Autowired
    GuestbookRepository guestbookRepository;


    public List<VisitorDTO> fetchEntries() {
        List<VisitorEntity> visitorEntityList = guestbookRepository.findAll();

        List<VisitorDTO> visitorDTOList = visitorEntityList.stream().map(visitorEntity -> {
            VisitorDTO visitorDTO = new VisitorDTO(visitorEntity.name, visitorEntity.comment);
            return visitorDTO;
        }).collect(Collectors.toList());

        return visitorDTOList;
    }

    public void saveVisitorComment(VisitorDTO visitorDTO) {

        guestbookRepository.save(new VisitorEntity(visitorDTO.name, visitorDTO.comment));
    }
}
