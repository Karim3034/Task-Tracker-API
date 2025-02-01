package com.karim.tasks.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String Details
) {
}
