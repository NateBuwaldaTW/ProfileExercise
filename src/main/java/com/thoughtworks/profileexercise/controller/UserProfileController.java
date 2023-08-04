package com.thoughtworks.profileexercise.controller;

import com.thoughtworks.profileexercise.service.UserProfileService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    public ResponseEntity<UserProfile> getUserProfile() {
        return ResponseEntity.ok(new UserProfile());
    }

    public ResponseEntity<List<SimplifiedProfile>> getAllProfiles() {
        return ResponseEntity.ok(service.fetchAllSimplifiedProfiles());
    }

    public ResponseEntity<Object> createProfile(UserProfile profile) {
        if (profile.getUsername() == null
                || profile.getFirstName() == null
                || profile.getLastName() == null
                || profile.getCity() == null
                || profile.getStateProvince() == null
                || profile.getAge() == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean createWasSuccessful = service.createUserProfile(profile);
        if (createWasSuccessful) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
