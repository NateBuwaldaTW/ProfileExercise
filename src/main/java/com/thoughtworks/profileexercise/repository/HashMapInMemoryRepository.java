package com.thoughtworks.profileexercise.repository;

import com.thoughtworks.profileexercise.controller.UserProfile;

public class HashMapInMemoryRepository implements InMemoryRepository {

    @Override
    public boolean save(UserProfile profile) {
        return false;
    }

}
