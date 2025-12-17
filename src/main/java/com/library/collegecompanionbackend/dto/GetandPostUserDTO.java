package com.library.collegecompanionbackend.dto;

import com.library.collegecompanionbackend.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record GetandPostUserDTO(
        String name,
        Long id,
        String email,
        @Enumerated(EnumType.STRING) Role role
) {
}
