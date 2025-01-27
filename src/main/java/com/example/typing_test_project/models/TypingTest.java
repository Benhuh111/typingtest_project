package com.example.typing_test_project.models;

import jakarta.persistence.*;

@Entity
public class TypingTest {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String difficulty;

        @Column(length = 1000)
        private String text;

        public TypingTest() {
        }

        public TypingTest(String difficulty, String text) {
            this.difficulty = difficulty;
            this.text = text;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
}