package com.example.typing_test_project.services;

import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.repositories.TypingTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypingTestService {

    @Autowired
    private TypingTestRepository typingTestRepository;

    public TypingTest getTypingTestByDifficulty(String difficulty) {
        return typingTestRepository.findByDifficulty(difficulty);
    }

    public TypingTest createTypingTest(String difficulty, String text) {
        TypingTest typingTest = new TypingTest();
        typingTest.setDifficulty(difficulty);
        typingTest.setText(text);
        return typingTestRepository.save(typingTest);
    }
}
