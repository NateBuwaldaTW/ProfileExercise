package com.thoughtworks.profileexercise.controller;

import org.springframework.http.ResponseEntity;

public class UserProfileController {

    public ResponseEntity<UserProfile> getUserProfile() {
        return ResponseEntity.ok(new UserProfile());
    }

}
