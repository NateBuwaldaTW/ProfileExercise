package com.thoughtworks.profileexercise.service;

import com.thoughtworks.profileexercise.controller.SimplifiedProfile;
import com.thoughtworks.profileexercise.controller.UserProfile;

import java.util.List;

public interface UserProfileService {
    boolean createUserProfile(UserProfile profile);

    List<SimplifiedProfile> fetchAllSimplifiedProfiles();
}
