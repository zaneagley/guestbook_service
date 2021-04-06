package com.guestbook;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class GuestbookController {

    public GuestbookService guestbookService;

    @GetMapping("comments")
    public List<String> fetchComments(){
        return guestbookService.fetchEntries();
    }




}
