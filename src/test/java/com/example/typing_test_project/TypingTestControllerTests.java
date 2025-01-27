package com.example.typing_test_project;

import com.example.typing_test_project.controllers.TypingTestController;
import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.services.TypingTestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TypingTestController.class)
public class TypingTestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TypingTestService typingTestService;

    @Test
    public void testGetTypingTestByDifficulty() throws Exception {
        TypingTest mockTest = new TypingTest("easy", "Sample text");
        when(typingTestService.getTypingTestByDifficulty("easy")).thenReturn(mockTest);

        mockMvc.perform(get("/api/typing-tests/difficulty/easy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.difficulty").value("easy"))
                .andExpect(jsonPath("$.text").value("Sample text"));
    }

    @Test
    public void testCreateTypingTest() throws Exception {
        TypingTest mockTest = new TypingTest("medium", "Another sample text");
        when(typingTestService.createTypingTest(Mockito.anyString(), Mockito.anyString())).thenReturn(mockTest);

        ObjectMapper objectMapper = new ObjectMapper();
        String typingTestJson = objectMapper.writeValueAsString(mockTest);

        mockMvc.perform(post("/api/typing-tests/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(typingTestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.difficulty").value("medium"))
                .andExpect(jsonPath("$.text").value("Another sample text"));
    }
}
