package com.thoughtworks.profileexercise.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserProfileControllerTest {

    @Test
    void controllerShouldBeInitialized() {
        var controller = new UserProfileController();
        Assertions.assertNotNull(controller);
    }

}
