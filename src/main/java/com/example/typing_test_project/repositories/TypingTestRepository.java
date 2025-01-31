package com.example.typing_test_project.repositories;

import com.example.typing_test_project.models.TypingTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypingTestRepository extends JpaRepository<TypingTest, Long> {
    List<TypingTest> findByDifficulty(String difficulty);
}