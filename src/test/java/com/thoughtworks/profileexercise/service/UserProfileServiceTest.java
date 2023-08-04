package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProfileServiceTest {

    private UserProfileService service;
    private UserProfile expectedProfile;
    private StubbedInMemoryRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubRepository = new StubbedInMemoryRepository();
        service = new UserProfileService(stubRepository);
        expectedProfile = new UserProfile();
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

    protected class StubbedInMemoryRepository implements InMemoryRepository {

        private final List<UserProfile> results = new ArrayList<>();

        public List<UserProfile> fetchResults() {
            return results;
        }

        @Override
        public boolean save(UserProfile profile) {
            results.add(profile);
            return true;
        }
    }

}
