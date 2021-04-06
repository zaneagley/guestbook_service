package com.guestbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestbookServiceTest {

    GuestbookService service;

    VisitorDTO visitorDTO1;

    @BeforeEach
    public void setup() {
        service = new GuestbookService();
        visitorDTO1 = new VisitorDTO();
        visitorDTO1.comment = "This is a comment";
        visitorDTO1.name = "Zackry";
    }

    @Test
    public void fetchEntriesReturnsNullWhenEmpty() {

        assertTrue(service.fetchEntries().isEmpty());
    }

    @Test
    public void fetchEntriesReturnsSingleComment() {

        service.entry.add(visitorDTO1);

        assertEquals(visitorDTO1, service.fetchEntries().get(0));
    }

    @Test
    public void fetchEntriesReturnsAllComments() {
        service.entry.add(visitorDTO1);
        service.entry.add(new VisitorDTO("Maanick", "Good"));

        assertEquals("This is a comment", service.fetchEntries().get(0).getComment());
        assertEquals("Good", service.fetchEntries().get(1).getComment());
    }

    @Test
    public void saveVisitorComment() {
        service.saveVisitorComment(visitorDTO1);

        assertEquals(visitorDTO1, service.fetchEntries().get(0));
    }

}
