package com.thoughtworks.profileexercise.repository;

import com.thoughtworks.profileexercise.controller.UserProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HashMapInMemoryRepository implements InMemoryRepository<UserProfile> {

    private final Map<UUID, UserProfile> storage = new HashMap<>();

    @Override
    public boolean save(UserProfile profile) {
        UUID key = UUID.randomUUID();

        var profileWithId = new UserProfile(profile);
        profileWithId.setId(key);

        storage.put(key, profileWithId);
        return true;
    }

    @Override
    public List<UserProfile> fetchAll() {
        return storage.values().stream().toList();
    }

}
