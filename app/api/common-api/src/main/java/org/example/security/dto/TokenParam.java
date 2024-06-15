package org.example.security.dto;

import lombok.Builder;

@Builder
public record TokenParam(
    String accessToken,
    String refreshToken
) {

}
