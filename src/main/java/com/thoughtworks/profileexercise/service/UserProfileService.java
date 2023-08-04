package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import com.thoughtworks.profileexercise.repository.InMemoryRepository;

public class UserProfileService {

    public static final String NOT_SPECIFIED_MESSAGE = "Not Specified";
    private final InMemoryRepository inMemoryRepository;

    public UserProfileService(InMemoryRepository inMemoryRepository) {

        this.inMemoryRepository = inMemoryRepository;
    }

    public boolean createUserProfile(UserProfile profile) {
        if (null != profile) {
            return inMemoryRepository.save(checkFavoriteColor(profile));
        }

        return false;
    }

    private UserProfile checkFavoriteColor(UserProfile originalProfile) {
        var updatedProfile = new UserProfile(originalProfile);

        if (null == originalProfile.getFavoriteColor()) {
            updatedProfile.setFavoriteColor(UserProfileService.NOT_SPECIFIED_MESSAGE);
        }

        return updatedProfile;
    }

}
