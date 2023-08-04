package com.thoughtworks.profileexercise.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class UserProfileControllerTest {

    private UserProfileController controller;

    @BeforeEach
    void setUp() {
        controller = new UserProfileController();
    }

    @Test
    void controllerShouldBeInitialized() {
        Assertions.assertNotNull(controller);
    }

    @Test
    void shouldGetAUserProfile() {
        UserProfile expectedProfile = new UserProfile();
        var expected = ResponseEntity.ok(expectedProfile);

        var actual = controller.getUserProfile();

        Assertions.assertEquals(expected, actual);
    }

}
