package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.SimplifiedProfile;
import com.thoughtworks.profileexercise.controller.UserProfile;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.thoughtworks.profileexercise.repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ColorLogicUserProfileServiceTest {

    private final int testStringSize = 10;

    private ColorLogicUserProfileService service;
    private UserProfile expectedProfile;
    private StubbedInMemoryRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubRepository = new StubbedInMemoryRepository();
        service = new ColorLogicUserProfileService(stubRepository);

        expectedProfile = new UserProfile();
        expectedProfile.setId(UUID.randomUUID());
        expectedProfile.setUsername(RandomStringUtils.random(testStringSize));
        expectedProfile.setFavoriteColor(RandomStringUtils.random(testStringSize));
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

    @Test
    void shouldFetchSimplifiedUserProfiles() {
        stubRepository.save(expectedProfile);

        var actual = service.fetchAllSimplifiedProfiles();

        int expectedSimplifiedProfileCount = 1;
        Assertions.assertEquals(expectedSimplifiedProfileCount, actual.size());

        SimplifiedProfile actualSimplifiedProfile = actual.get(0);
        Assertions.assertEquals(expectedProfile.getId().toString(), actualSimplifiedProfile.getId());
        Assertions.assertEquals(expectedProfile.getUsername(), actualSimplifiedProfile.getUsername());
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
