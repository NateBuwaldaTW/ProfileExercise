package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import repository.InMemoryRepository;

public class UserProfileService {

    private final InMemoryRepository inMemoryRepository;

    public UserProfileService(InMemoryRepository inMemoryRepository) {

        this.inMemoryRepository = inMemoryRepository;
    }

    public boolean createUserProfile(UserProfile profile) {
        if (null != profile) {
            var savedResult = inMemoryRepository.save(profile);
            return savedResult;
        }

        return false;
    }

}
