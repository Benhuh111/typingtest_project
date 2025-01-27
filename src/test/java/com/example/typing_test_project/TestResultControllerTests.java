package com.example.typing_test_project;

import com.example.typing_test_project.controllers.TestResultController;
import com.example.typing_test_project.models.TestResult;
import com.example.typing_test_project.services.TestResultService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TestResultController.class)
public class TestResultControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestResultService testResultService;

    @Test
    public void testSubmitTestResult() throws Exception {
        TestResult mockResult = new TestResult(1L, 50, 80.0, LocalDateTime.now());
        when(testResultService.saveTestResult(Mockito.any(TestResult.class))).thenReturn(mockResult);

        mockMvc.perform(post("/api/test-results/submit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\":1,\"wpm\":50,\"accuracy\":80.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.wpm").value(50))
                .andExpect(jsonPath("$.accuracy").value(80.0));
    }

    @Test
    public void testGetTestResultsByUserId() throws Exception {
        TestResult mockResult = new TestResult(1L, 60, 90.0, LocalDateTime.now());
        when(testResultService.getTestResultsByUserId(1L)).thenReturn(List.of(mockResult));

        mockMvc.perform(get("/api/test-results/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$[0].wpm").value(60))
                .andExpect(jsonPath("$[0].accuracy").value(90.0));
    }
}