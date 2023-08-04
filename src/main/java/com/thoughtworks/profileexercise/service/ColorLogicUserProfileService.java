package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.SimplifiedProfile;
import com.thoughtworks.profileexercise.controller.UserProfile;
import com.thoughtworks.profileexercise.repository.InMemoryRepository;

import java.util.List;

public class ColorLogicUserProfileService implements UserProfileService {

    public static final String NOT_SPECIFIED_MESSAGE = "Not Specified";
    private final InMemoryRepository<UserProfile> inMemoryRepository;

    public ColorLogicUserProfileService(InMemoryRepository<UserProfile> inMemoryRepository) {

        this.inMemoryRepository = inMemoryRepository;
    }

    @Override
    public boolean createUserProfile(UserProfile profile) {
        if (null != profile) {
            return inMemoryRepository.save(checkFavoriteColor(profile));
        }

        return false;
    }

    @Override
    public List<SimplifiedProfile> fetchAllSimplifiedProfiles() {
        return null;
    }

    private UserProfile checkFavoriteColor(UserProfile originalProfile) {
        var updatedProfile = new UserProfile(originalProfile);

        if (null == originalProfile.getFavoriteColor()) {
            updatedProfile.setFavoriteColor(ColorLogicUserProfileService.NOT_SPECIFIED_MESSAGE);
        }

        return updatedProfile;
    }

}
