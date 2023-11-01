package org.application;

import java.util.Objects;

public class User {

    private final String fullName;
    private final String phoneNumber;
    private final String email;

    public User(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return fullName + " " + phoneNumber + " " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber, email);
    }
}
