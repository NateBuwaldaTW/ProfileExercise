package com.thoughtworks.profileexercise.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserProfileServiceTest {

    @Test
    void serviceIsInstantiated() {
        var service = new UserProfileService();

        Assertions.assertNotNull(service);
    }

}
