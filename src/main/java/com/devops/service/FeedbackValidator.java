package com.devops.service;

public final class FeedbackValidator {
    private FeedbackValidator() {
    }

    public static boolean isValid(String name, String email, String feedback) {
        return notBlank(name) && notBlank(email) && email.contains("@") && notBlank(feedback);
    }

    private static boolean notBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
