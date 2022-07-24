package com.compile.testcompilerspring.controllers;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationControllerTest {

    @Test
    void createItemPost() {
        try {
            RegistrationController.createUserFromJsonString("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}