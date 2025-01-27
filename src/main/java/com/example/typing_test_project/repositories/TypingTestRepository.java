package com.example.typing_test_project.repositories;

import com.example.typing_test_project.models.TypingTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypingTestRepository extends JpaRepository<TypingTest, Long> {
    TypingTest findByDifficulty(String difficulty);
}