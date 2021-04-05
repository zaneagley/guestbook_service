package com.guestbook;

import org.springframework.stereotype.Service;

@Service
public class GuestbookService {

    String entry;


    public String fetchEntries() {


        return entry;
    }
}
