package repository;

import com.thoughtworks.profileexercise.controller.UserProfile;

public interface InMemoryRepository {
    boolean save(UserProfile profile);
}
