package com.devops.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackValidatorTest {

    @Test
    void acceptsValidFeedback() {
        assertTrue(FeedbackValidator.isValid("Asha", "asha@example.com", "Great mentoring support"));
    }

    @Test
    void rejectsMissingFeedback() {
        assertFalse(FeedbackValidator.isValid("Asha", "asha@example.com", ""));
    }

    @Test
    void rejectsInvalidEmail() {
        assertFalse(FeedbackValidator.isValid("Asha", "asha-example.com", "Great mentoring support"));
    }
}
