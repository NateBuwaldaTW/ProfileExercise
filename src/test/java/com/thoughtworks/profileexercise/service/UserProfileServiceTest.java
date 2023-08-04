package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class UserProfileServiceTest {

    private final String expectedFavoriteColor = "Green";

    private UserProfileService service;
    private UserProfile expectedProfile;
    private StubbedInMemoryRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubRepository = new StubbedInMemoryRepository();
        service = new UserProfileService(stubRepository);

        expectedProfile = new UserProfile();
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

        var actualSavedProfiles = stubRepository.fetchResults();
        int expectedProfileSavedCount = 1;
        Assertions.assertEquals(expectedProfileSavedCount, actualSavedProfiles.size());
        Assertions.assertEquals(expectedProfile, actualSavedProfiles.get(0));
    }

    @Test
    void shouldHandleUserProfileWithoutColor() {
        expectedProfile.setFavoriteColor(null);

        var actual = service.createUserProfile(expectedProfile);
        Assertions.assertTrue(actual);

        var actualSavedProfiles = stubRepository.fetchResults();
        int expectedProfileSavedCount = 1;
        Assertions.assertEquals(expectedProfileSavedCount, actualSavedProfiles.size());
        Assertions.assertEquals(UserProfileService.NOT_SPECIFIED_MESSAGE, actualSavedProfiles.get(0).getFavoriteColor());
    }

    protected class StubbedInMemoryRepository implements InMemoryRepository {

        private final List<UserProfile> results = new ArrayList<>();

        protected List<UserProfile> fetchResults() {
            return results;
        }

        @Override
        public boolean save(UserProfile profile) {
            results.add(profile);
            return true;
        }
    }

}
