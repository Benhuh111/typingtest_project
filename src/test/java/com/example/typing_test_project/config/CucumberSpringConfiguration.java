package com.example.typing_test_project.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.example.typing_test_project.TypingTestProjectApplication;

@CucumberContextConfiguration
@SpringBootTest
@ContextConfiguration(classes = TypingTestProjectApplication.class)
public class CucumberSpringConfiguration {
}
