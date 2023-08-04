package com.thoughtworks.profileexercise.repository;

import com.thoughtworks.profileexercise.controller.UserProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapInMemoryRepositoryTest {

    private HashMapInMemoryRepository repository;

    @BeforeEach
    void setUp() {
        repository = new HashMapInMemoryRepository();
    }

    @Test
    void repositoryIsInstantiated() {
        Assertions.assertNotNull(repository);
    }

    @Test
    void shouldSaveAProfile() {
        var expectedProfile = new UserProfile();

        var actual = repository.save(expectedProfile);
        Assertions.assertTrue(actual);

        var actualProfile = repository.fetchAll();
        var expectedProfileCount = 1;
        Assertions.assertEquals(expectedProfileCount, actualProfile.size());
        Assertions.assertNotNull(actualProfile.get(0).getId());
    }

}
