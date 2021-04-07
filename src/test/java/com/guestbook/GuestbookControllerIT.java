package com.guestbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GuestbookControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void fetchEmptyList() throws Exception {

        mockMvc.perform(get("/comments"))
                .andExpect(status().isOk());

    }

    @Test
    void postCommentTest() throws Exception {
        VisitorDTO input = new VisitorDTO("Zackry","Good");
        mockMvc.perform(
                post("/comments")
                        .content(objectMapper.writeValueAsString(input))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated()).andDo(document("PostComment"));
    }

    @Test
    void getCommentTest() throws Exception {
        VisitorDTO input = new VisitorDTO("Zackry","This is a comment");
        mockMvc.perform(
                post("/comments")
                        .content(objectMapper.writeValueAsString(input))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isCreated());

        mockMvc.perform(get("/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("Zackry"))
                .andExpect(jsonPath("[0].comment").value("This is a comment"))
                .andDo(document("Comments", responseFields(
                        fieldWithPath("[0].name").description("Zackry"),
                        fieldWithPath("[0].comment").description("This is a comment"))));

    }

}
