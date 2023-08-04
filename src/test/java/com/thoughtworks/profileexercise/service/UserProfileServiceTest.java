package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserProfileServiceTest {

    private UserProfileService service;

    @BeforeEach
    void setUp() {
        service = new UserProfileService();
    }

    @Test
    void serviceIsInstantiated() {
        Assertions.assertNotNull(service);
    }

    @Test
    void shouldCreateUserProfile() {
        var expectedProfile = new UserProfile();

        var actual = service.createUserProfile(expectedProfile);

        Assertions.assertTrue(actual);
    }

}
