package com.example.typing_test_project.services;

import com.example.typing_test_project.models.TestResult;

import com.example.typing_test_project.repositories.TestResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestResultService {

    @Autowired
    private TestResultRepository testResultRepository;

    public TestResult saveTestResult(TestResult testResult) {
        return testResultRepository.save(testResult);
    }

    public List<TestResult> getTestResultsByUserId(Long userId) {
        return testResultRepository.findByUserId(userId);
    }

}
