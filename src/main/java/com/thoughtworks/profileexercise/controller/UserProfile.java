package com.thoughtworks.profileexercise.controller;

import java.util.Objects;

public class UserProfile {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
