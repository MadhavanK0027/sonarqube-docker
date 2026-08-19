package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testGetMessage() {
        assertEquals("Week 12 CI/CD Pipeline", App.getMessage());
    }
}