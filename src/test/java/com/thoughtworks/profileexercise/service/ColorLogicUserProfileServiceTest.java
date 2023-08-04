package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.thoughtworks.profileexercise.repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class ColorLogicUserProfileServiceTest {

    private ColorLogicUserProfileService service;
    private UserProfile expectedProfile;
    private StubbedInMemoryRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubRepository = new StubbedInMemoryRepository();
        service = new ColorLogicUserProfileService(stubRepository);

        expectedProfile = new UserProfile();
        String expectedFavoriteColor = "Green";
        expectedProfile.setFavoriteColor(expectedFavoriteColor);
    }

    @Test
    void serviceIsInstantiated() {
        Assertions.assertNotNull(service);
    }

    @Test
    void shouldCreateUserProfile() {
        var actual = service.createUserProfile(expectedProfile);

        Assertions.assertTrue(actual);
    }

    @Test
    void shouldSaveCreatedUserProfile() {
        var actual = service.createUserProfile(expectedProfile);
        Assertions.assertTrue(actual);

        var actualSavedProfiles = stubRepository.fetchAll();
        int expectedProfileSavedCount = 1;
        Assertions.assertEquals(expectedProfileSavedCount, actualSavedProfiles.size());
        Assertions.assertEquals(expectedProfile, actualSavedProfiles.get(0));
    }

    @Test
    void shouldHandleUserProfileWithoutColor() {
        expectedProfile.setFavoriteColor(null);

        var actual = service.createUserProfile(expectedProfile);
        Assertions.assertTrue(actual);

        var actualSavedProfiles = stubRepository.fetchAll();
        int expectedProfileSavedCount = 1;
        Assertions.assertEquals(expectedProfileSavedCount, actualSavedProfiles.size());
        Assertions.assertEquals(ColorLogicUserProfileService.NOT_SPECIFIED_MESSAGE, actualSavedProfiles.get(0).getFavoriteColor());
    }

    protected static class StubbedInMemoryRepository implements InMemoryRepository<UserProfile> {

        private final List<UserProfile> results = new ArrayList<>();

        @Override
        public boolean save(UserProfile profile) {
            results.add(profile);
            return true;
        }

        @Override
        public List<UserProfile> fetchAll() {
            return results;
        }
    }

}
