package com.thoughtworks.profileexercise.controller;

import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class UserProfileController {

    public ResponseEntity<UserProfile> getUserProfile() {
        return ResponseEntity.ok(new UserProfile());
    }

    public ResponseEntity<List<UserProfile>> getAllProfiles() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    public ResponseEntity<Object> createProfile(UserProfile profile) {
        if (profile.getUsername() == null
                || profile.getFirstName() == null
                || profile.getLastName() == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
