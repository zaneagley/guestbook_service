package com.guestbook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestbookController {
    @Autowired
    public GuestbookService guestbookService;

    @GetMapping("comments")
    public List<String> fetchComments(){
        return guestbookService.fetchEntries();
    }




}
