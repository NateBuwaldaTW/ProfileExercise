package com.thoughtworks.profileexercise.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class UserProfileControllerTest {

    private UserProfileController controller;
    private UserProfile expectedProfile;

    @BeforeEach
    void setUp() {
        controller = new UserProfileController();

        expectedProfile = new UserProfile();
        expectedProfile.setUsername(RandomStringUtils.random(10));
        expectedProfile.setFirstName(RandomStringUtils.random(10));
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

    @Test
    void shouldGetAllUserProfiles() {
        List<UserProfile> expectedProfiles = Collections.emptyList();
        var expected = ResponseEntity.ok(expectedProfiles);

        var actual = controller.getAllProfiles();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCreateAUserProfile() {
        var expected = ResponseEntity.ok().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateAUserProfileIfUsernameIsMissing() {
        expectedProfile.setUsername(null);
        var expected = ResponseEntity.badRequest().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateAUserProfileIfFirstNameIsMissing() {
        expectedProfile.setFirstName(null);
        var expected = ResponseEntity.badRequest().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

}
