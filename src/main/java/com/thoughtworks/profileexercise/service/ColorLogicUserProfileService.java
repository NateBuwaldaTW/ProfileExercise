package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.SimplifiedProfile;
import com.thoughtworks.profileexercise.controller.UserProfile;
import com.thoughtworks.profileexercise.repository.InMemoryRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        List<UserProfile> userProfiles = inMemoryRepository.fetchAll();
        return userProfiles.stream().map(profile -> {
           var simplified = new SimplifiedProfile();
           simplified.setId(profile.getId().toString());
           simplified.setUsername(profile.getUsername());

           return simplified;
        }).collect(Collectors.toList());
    }

    private UserProfile checkFavoriteColor(UserProfile originalProfile) {
        var updatedProfile = new UserProfile(originalProfile);

        if (null == originalProfile.getFavoriteColor()) {
            updatedProfile.setFavoriteColor(ColorLogicUserProfileService.NOT_SPECIFIED_MESSAGE);
        }

        return updatedProfile;
    }

}
