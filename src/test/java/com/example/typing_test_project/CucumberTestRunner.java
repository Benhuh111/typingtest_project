package com.example.typing_test_project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.typing_test_project", "com.example.typing_test_project.config"}
)
public class CucumberTestRunner {
}
