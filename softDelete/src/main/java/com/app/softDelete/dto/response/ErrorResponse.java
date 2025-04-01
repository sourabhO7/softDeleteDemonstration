package com.app.softDelete.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@Getter
@NoArgsConstructor
public class ErrorResponse {
    private ZonedDateTime timestamp = ZonedDateTime.now();
    private String message;
    private String description;

    public ErrorResponse(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
