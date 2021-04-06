package com.guestbook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestbookController {

    @Autowired
    public GuestbookService guestbookService;

    @GetMapping("comments")
    public List<VisitorDTO> fetchComments(){
        return guestbookService.fetchEntries();
    }

    @PostMapping("comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void postComment(@RequestBody VisitorDTO visitorDTO){
        guestbookService.saveVisitorComment(visitorDTO);
    }




}
