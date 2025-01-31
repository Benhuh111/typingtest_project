package com.example.typing_test_project;

import com.example.typing_test_project.models.TestResult;
import com.example.typing_test_project.repositories.TestResultRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManagingTestResultsSteps {

    @Autowired
    private TestResultRepository testResultRepository;

    private TestResult testResult;
    private List<TestResult> retrievedResults;

    @Given("A user with ID {int}")
    public void a_user_with_id(Integer userId) {
        testResult = new TestResult();
        testResult.setUserId(Long.valueOf(userId));
    }
    @When("The user submits a test result with {int} WPM and {double}% accuracy")
    public void the_user_submits_a_test_result_with_wpm_and_accuracy(Integer wpm, Double accuracy) {
        testResult.setWpm(wpm);
        testResult.setAccuracy(accuracy);
        testResult.setDate(LocalDateTime.now());
        testResultRepository.save(testResult);
    }
    @Then("The test result is saved with the user's ID, WPM, accuracy, and the current date")
    public void the_test_result_is_saved_with_the_user_s_id_wpm_accuracy_and_the_current_date() {
        TestResult savedResult = testResultRepository.findById(testResult.getId()).orElse(null);
        assertNotNull(savedResult);
        assertNotNull(savedResult.getDate());
    }

    @Given("A user with ID {int} has submitted test results")
    public void a_user_with_id_has_submitted_test_results(Integer userId) {
        testResult = new TestResult();
        testResult.setUserId(Long.valueOf(userId));
        testResult.setWpm(50);
        testResult.setAccuracy(95.5);
        testResult.setDate(LocalDateTime.now());
        testResultRepository.save(testResult);

    }
    @When("We retrieve test results for user ID {int}")
    public void we_retrieve_test_results_for_user_id(Integer userId) {
        retrievedResults = testResultRepository.findByUserId(Long.valueOf(userId));
    }
    @Then("The retrieved test results list is not empty")
    public void the_retrieved_test_results_list_is_not_empty() {
        assertFalse(retrievedResults.isEmpty());
    }

}
