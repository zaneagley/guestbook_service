package com.guestbook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestbookService {

    List<VisitorDTO> entry = new ArrayList<>();


    public List<VisitorDTO> fetchEntries() {

        return entry;
    }

    public void saveVisitorComment(VisitorDTO visitorDTO) {
        entry.add(visitorDTO);

    }
}
