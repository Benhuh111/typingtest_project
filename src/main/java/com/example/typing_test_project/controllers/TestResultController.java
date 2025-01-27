package com.example.typing_test_project.controllers;

import com.example.typing_test_project.models.TestResult;
import com.example.typing_test_project.services.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-results")
public class TestResultController {

    @Autowired
    private TestResultService testResultService;

    @PostMapping("/submit")
    public ResponseEntity<TestResult> submitTestResult(@RequestBody TestResult testResult) {
        TestResult savedResult = testResultService.saveTestResult(testResult);
        return ResponseEntity.ok(savedResult);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TestResult>> getTestResultsByUserId(@PathVariable Long userId) {
        List<TestResult> results = testResultService.getTestResultsByUserId(userId);
        return ResponseEntity.ok(results);
    }
}