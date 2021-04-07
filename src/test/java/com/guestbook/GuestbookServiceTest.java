package com.guestbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GuestbookServiceTest {

    @InjectMocks
    GuestbookService service;

    @Mock
    GuestbookRepository guestbookRepository;

    VisitorDTO visitorDTO1;

    @BeforeEach
    public void setup() {
        service = new GuestbookService(guestbookRepository);
        visitorDTO1 = new VisitorDTO();
        visitorDTO1.comment = "This is a comment";
        visitorDTO1.name = "Zackry";
    }

    @Test
    public void fetchEntriesReturnsNullWhenEmpty() {
        when(guestbookRepository.findAll()).thenReturn(new ArrayList<>());

        assertTrue(service.fetchEntries().isEmpty());
    }

    @Test
    public void fetchEntriesReturnsSingleComment() {

        when(guestbookRepository.findAll()).thenReturn(Collections.singletonList(
                new VisitorEntity(visitorDTO1.name, visitorDTO1.comment)));

        assertEquals(visitorDTO1, service.fetchEntries().get(0));
    }

    @Test
    public void fetchEntriesReturnsAllComments() {
        List<VisitorEntity> visitorEntityList = new ArrayList<>();
        visitorEntityList.add(new VisitorEntity(visitorDTO1.name, visitorDTO1.comment));
        visitorEntityList.add(new VisitorEntity("Maanick", "Good"));

        when(guestbookRepository.findAll()).thenReturn(visitorEntityList);

        assertEquals("This is a comment", service.fetchEntries().get(0).getComment());
        assertEquals("Good", service.fetchEntries().get(1).getComment());
    }

    @Test
    public void saveVisitorComment() {
        when(guestbookRepository.findAll()).thenReturn(Collections.singletonList(
                new VisitorEntity(visitorDTO1.name, visitorDTO1.comment)));

        service.saveVisitorComment(visitorDTO1);

        assertEquals(visitorDTO1, service.fetchEntries().get(0));
    }

}
