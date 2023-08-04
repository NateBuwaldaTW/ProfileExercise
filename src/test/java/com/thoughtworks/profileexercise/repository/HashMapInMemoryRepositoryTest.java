package com.thoughtworks.profileexercise.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapInMemoryRepositoryTest {

    @Test
    void repositoryIsInstantiated() {
        var repository = new HashMapInMemoryRepository();

        Assertions.assertNotNull(repository);
    }

}
