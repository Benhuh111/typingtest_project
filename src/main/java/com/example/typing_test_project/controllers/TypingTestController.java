package com.example.typing_test_project.controllers;

import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.services.TypingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typing-tests")
public class TypingTestController {

    @Autowired
    private TypingTestService typingTestService;

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<TypingTest>> getTypingTestsByDifficulty(@PathVariable String difficulty) {
        List<TypingTest> typingTests = typingTestService.getTypingTestsByDifficulty(difficulty);
        return typingTests != null && !typingTests.isEmpty() ? ResponseEntity.ok(typingTests) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<TypingTest> createTypingTest(@RequestBody TypingTest typingTest) {
        TypingTest createdTest = typingTestService.createTypingTest(typingTest.getDifficulty(), typingTest.getText());
        return ResponseEntity.ok(createdTest);
    }
}
