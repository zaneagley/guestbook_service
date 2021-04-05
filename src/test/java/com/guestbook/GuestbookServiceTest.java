package com.guestbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestbookServiceTest {

    GuestbookService service;


    @BeforeEach
    public void setup() {
        service = new GuestbookService();
    }

    @Test
    public void fetchEntriesReturnsNullWhenEmpty() {

        assertTrue(service.fetchEntries().isEmpty());
    }

    @Test
    public void fetchEntriesReturnsSingleComment() {

        service.entry.add("This is a comment.");

        assertEquals("This is a comment.", service.fetchEntries().get(0));
    }

    @Test
    public void fetchEntriesReturnsAllComments() {
        service.entry.add("This is a comment.");
        service.entry.add("This is a second comment.");

        assertEquals("This is a comment.", service.fetchEntries().get(0));
        assertEquals("This is a second comment.", service.fetchEntries().get(1));
    }

}
