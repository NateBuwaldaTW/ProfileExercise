package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.UserProfile;
import com.thoughtworks.profileexercise.repository.InMemoryRepository;

public class ColorLogicUserProfileService implements UserProfileService {

    public static final String NOT_SPECIFIED_MESSAGE = "Not Specified";
    private final InMemoryRepository inMemoryRepository;

    public ColorLogicUserProfileService(InMemoryRepository inMemoryRepository) {

        this.inMemoryRepository = inMemoryRepository;
    }

    @Override
    public boolean createUserProfile(UserProfile profile) {
        if (null != profile) {
            return inMemoryRepository.save(checkFavoriteColor(profile));
        }

        return false;
    }

    private UserProfile checkFavoriteColor(UserProfile originalProfile) {
        var updatedProfile = new UserProfile(originalProfile);

        if (null == originalProfile.getFavoriteColor()) {
            updatedProfile.setFavoriteColor(ColorLogicUserProfileService.NOT_SPECIFIED_MESSAGE);
        }

        return updatedProfile;
    }

}
