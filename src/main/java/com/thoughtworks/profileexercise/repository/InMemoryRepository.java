package com.thoughtworks.profileexercise.repository;

import com.thoughtworks.profileexercise.controller.UserProfile;

import java.util.List;

public interface InMemoryRepository<T> {
    boolean save(UserProfile profile);

    List<T> fetchAll();
}
