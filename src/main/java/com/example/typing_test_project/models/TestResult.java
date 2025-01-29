package com.example.typing_test_project.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private int wpm;

    private double accuracy;

    private LocalDateTime testDate;


    public TestResult(Long userId, int wpm, double accuracy, LocalDateTime testDate) {
        this.userId = userId;
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.testDate = testDate;
    }

    public TestResult() {
    }

    public TestResult(Long id, double v, double v1) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getWpm() {
        return wpm;
    }

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public LocalDateTime getDate() {
        return testDate;
    }

    public void setDate(LocalDateTime testDate) {
        this.testDate = testDate;
    }
}