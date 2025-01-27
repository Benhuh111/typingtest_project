package com.example.typing_test_project.util;

import com.example.typing_test_project.models.TestResult;
import com.example.typing_test_project.models.TypingTest;
import com.example.typing_test_project.models.User;
import com.example.typing_test_project.repositories.TestResultRepository;
import com.example.typing_test_project.repositories.TypingTestRepository;
import com.example.typing_test_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypingTestRepository typingTestRepository;

    @Autowired
    private TestResultRepository testResultRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insert sample users
        User user1 = new User("Alice", "alice@gmail.com");
        User user2 = new User("Bob", "bob@gmail.com");
        userRepository.save(user1);
        userRepository.save(user2);

        // Insert sample typing tests
        TypingTest test1 = new TypingTest("easy", "This is an easy test.");
        TypingTest test2 = new TypingTest("medium", "This is a medium test.");
        typingTestRepository.save(test1);
        typingTestRepository.save(test2);

        // Insert sample test results
        TestResult result1 = new TestResult(user1.getId(), 75.0, 95.0);
        TestResult result2 = new TestResult(user2.getId(), 60.0, 85.0);
        testResultRepository.save(result1);
        testResultRepository.save(result2);

        System.out.println("Database initialized with sample data.");
    }
}
