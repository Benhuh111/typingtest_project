package com.example.typing_test_project.services;

import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.repositories.TypingTestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypingTestService {

    private static final Logger logger = LoggerFactory.getLogger(TypingTestService.class);

    @Autowired
    private TypingTestRepository typingTestRepository;

    public List<TypingTest> getTypingTestsByDifficulty(String difficulty) {
        logger.info("Retrieving typing tests with difficulty: {}", difficulty);
        return typingTestRepository.findByDifficulty(difficulty);
    }

    public TypingTest createTypingTest(String difficulty, String text) {
        logger.info("Creating typing test with difficulty: {} and text: {}", difficulty, text);
        TypingTest typingTest = new TypingTest();
        typingTest.setDifficulty(difficulty);
        typingTest.setText(text);
        return typingTestRepository.save(typingTest);
    }
}
