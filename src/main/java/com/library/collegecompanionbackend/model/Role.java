package com.library.collegecompanionbackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    STUDENT ("Student"),
    TEACHER ("Teacher");

    private final String description;
    Role(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
    @JsonCreator
    public static Role fromString(String description) {
        for (Role role : Role.values()) {
            if (role.getDescription().equals(description)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role "+description);
    }

}
