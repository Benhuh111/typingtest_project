package com.example.typing_test_project;

import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.services.TypingTestService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ManagingTypingTestsSteps {

    @Autowired
    private TypingTestService typingTestService;

    private TypingTest typingTest;
    private List<TypingTest> retrievedTypingTests;

    @Given("A typing test with difficulty {string} and some text")
    public void a_typing_test_with_difficulty_and_some_text(String difficulty) {
        typingTest = new TypingTest(difficulty, "Sample text for " + difficulty);
    }

    @When("We create the typing test")
    public void we_create_the_typing_test() {
        typingTestService.createTypingTest(typingTest.getDifficulty(), typingTest.getText());
    }

    @Then("The typing test is saved with the specified difficulty and text")
    public void the_typing_test_is_saved_with_the_specified_difficulty_and_text() {
        TypingTest savedTest = typingTestService.getTypingTestsByDifficulty(typingTest.getDifficulty()).get(0);
        assertNotNull(savedTest);
        assertEquals(typingTest.getDifficulty(), savedTest.getDifficulty());
        assertEquals(typingTest.getText(), savedTest.getText());
    }

    @Given("A typing test with difficulty {string} exists")
    public void a_typing_test_with_difficulty_exists(String difficulty) {
        typingTest = new TypingTest(difficulty, "Sample text for " + difficulty);
    }

    @When("We retrieve the typing test by difficulty {string}")
    public void we_retrieve_the_typing_test_by_difficulty(String difficulty) {
        retrievedTypingTests = typingTestService.getTypingTestsByDifficulty(difficulty);
    }

    @Then("The retrieved typing test has difficulty {string}")
    public void the_retrieved_typing_test_has_difficulty(String difficulty) {
        assertFalse(retrievedTypingTests.isEmpty());
        for (TypingTest test : retrievedTypingTests) {
            assertEquals(difficulty, test.getDifficulty());
        }
    }
}