package com.example.typing_test_project.controllers;

import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.services.TypingTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typing-tests")
public class TypingTestController {

    @Autowired
    private TypingTestService typingTestService;

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<TypingTest> getTypingTestByDifficulty(@PathVariable String difficulty) {
        TypingTest typingTest = typingTestService.getTypingTestByDifficulty(difficulty);
        return typingTest != null ? ResponseEntity.ok(typingTest) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<TypingTest> createTypingTest(@RequestBody TypingTest typingTest) {
        TypingTest createdTypingTest = typingTestService.createTypingTest(typingTest);
        return ResponseEntity.ok(createdTypingTest);
    }
}
