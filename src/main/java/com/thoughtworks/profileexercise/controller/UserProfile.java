package com.thoughtworks.profileexercise.controller;

import java.util.Objects;

public class UserProfile {

    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String stateProvince;
    private Integer age;
    private String favoriteColor;

    public UserProfile() {
        super();
    }

    public UserProfile(UserProfile profileToCopy) {
        super();
        this.setAge(profileToCopy.getAge());
        this.setFirstName(profileToCopy.getFirstName());
        this.setLastName(profileToCopy.getLastName());
        this.setCity(profileToCopy.getCity());
        this.setStateProvince(profileToCopy.getStateProvince());
        this.setUsername(profileToCopy.getUsername());
        this.setFavoriteColor(profileToCopy.getFavoriteColor());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(city, that.city) && Objects.equals(stateProvince, that.stateProvince) && Objects.equals(age, that.age) && Objects.equals(favoriteColor, that.favoriteColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, city, stateProvince, age, favoriteColor);
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }
}
