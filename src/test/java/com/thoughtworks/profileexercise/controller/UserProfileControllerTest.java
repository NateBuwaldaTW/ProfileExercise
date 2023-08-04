package com.thoughtworks.profileexercise.controller;

import com.thoughtworks.profileexercise.service.UserProfileService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserProfileControllerTest {

    private final int testStringSize = 10;
    private UserProfileController controller;
    private StubbedUserProfileService service;
    private UserProfile expectedProfile;

    @BeforeEach
    void setUp() {
        service = new StubbedUserProfileService();
        controller = new UserProfileController(service);

        expectedProfile = new UserProfile();
        expectedProfile.setUsername(RandomStringUtils.random(testStringSize));
        expectedProfile.setFirstName(RandomStringUtils.random(testStringSize));
        expectedProfile.setLastName(RandomStringUtils.random(testStringSize));
        expectedProfile.setCity(RandomStringUtils.random(testStringSize));
        expectedProfile.setStateProvince(RandomStringUtils.random(testStringSize));
        expectedProfile.setAge(RandomUtils.nextInt());

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
        var expectedSimplifiedProfile = new SimplifiedProfile();
        expectedSimplifiedProfile.setId(UUID.randomUUID().toString());
        expectedSimplifiedProfile.setUsername(RandomStringUtils.random(testStringSize));

        List<SimplifiedProfile> expectedProfiles = new ArrayList<>();
        expectedProfiles.add(expectedSimplifiedProfile);

        service.stubSimplifiedProfiles(expectedProfiles);

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
    void shouldHandleResultIfUserProfileNotCreated() {
        service.stubCreateResponse(false);
        var expected = ResponseEntity.internalServerError().build();

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

    @Test
    void shouldNotCreateAUserProfileIfLastNameIsMissing() {
        expectedProfile.setLastName(null);
        var expected = ResponseEntity.badRequest().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateAUserProfileIfCityIsMissing() {
        expectedProfile.setCity(null);
        var expected = ResponseEntity.badRequest().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateAUserProfileIfStateProvinceIsMissing() {
        expectedProfile.setStateProvince(null);
        var expected = ResponseEntity.badRequest().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotCreateAUserProfileIfAgeIsMissing() {
        expectedProfile.setAge(null);
        var expected = ResponseEntity.badRequest().build();

        var actual = controller.createProfile(expectedProfile);

        Assertions.assertEquals(expected, actual);
    }

    protected static class StubbedUserProfileService implements UserProfileService {

        private boolean createResponse = true;
        private List<SimplifiedProfile> simplifiedProfilesResponse;

        @Override
        public boolean createUserProfile(UserProfile profile) {
            return createResponse;
        }

        @Override
        public List<SimplifiedProfile> fetchAllSimplifiedProfiles() {
            return simplifiedProfilesResponse;
        }

        public void stubCreateResponse(boolean cannedResponse) {
            createResponse = cannedResponse;
        }

        public void stubSimplifiedProfiles(List<SimplifiedProfile> simplifiedProfiles) {
            simplifiedProfilesResponse = simplifiedProfiles;
        }
    }

}
