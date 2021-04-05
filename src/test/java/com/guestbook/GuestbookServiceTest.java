package com.guestbook;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class GuestbookServiceTest {

    GuestbookService service;


    @BeforeEach
    public void setup() {
        service = new GuestbookService();
    }


    @Test
    public void test() {

        assertNull(service.fetchEntries());
    }

}
