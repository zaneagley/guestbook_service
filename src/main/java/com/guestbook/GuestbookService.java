package com.guestbook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestbookService {

    List<String> entry = new ArrayList<>();


    public List<String> fetchEntries() {

        return entry;
    }
}
