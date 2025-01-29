package com.example.typing_test_project;

import com.example.typing_test_project.controllers.UserController;
import com.example.typing_test_project.services.UserService;
import com.example.typing_test_project.util.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class GlobalExceptionHandlerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testHandleResourceNotFoundException() throws Exception {

        when(userService.getUserById(999L)).thenThrow(new ResourceNotFoundException("User not found"));
        // Simulate a ResourceNotFoundException being thrown in the service layer
        mockMvc.perform(get("/api/users/999"))
                .andExpect(status().isNotFound())  // Expect HTTP 404
                .andExpect(content().string("User not found"));  // Expect the exception message
    }

    @Test
    public void testHandleGenericException() throws Exception {
        // Simulate a generic exception being thrown
        when(userService.getUserById(1L)).thenThrow(new RuntimeException("Something went wrong"));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isInternalServerError())  // Expect HTTP 500
                .andExpect(content().string("Something went wrong"));  // Expect the exception message
    }

    @Test
    public void testHandleIllegalArgumentException() throws Exception {
        // Simulate an IllegalArgumentException being thrown
        when(userService.createUser("John", "invalid-email")).thenThrow(new IllegalArgumentException("Invalid email format"));

        mockMvc.perform(post("/api/users/create")
                        .param("name", "John")
                        .param("email", "invalid-email"))
                .andExpect(status().isBadRequest())  // Expect HTTP 400
                .andExpect(content().string("Invalid email format"));  // Expect the exception message
    }
}
