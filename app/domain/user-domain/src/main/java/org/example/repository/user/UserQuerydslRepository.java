package org.example.repository.user;

import java.util.Optional;
import java.util.UUID;
import org.example.dto.response.UserProfileDomainResponse;

public interface UserQuerydslRepository {

    Optional<UserProfileDomainResponse> findUserProfileById(UUID userId);

    boolean existsByNickname(String nickname);

    Optional<String> findUserFcmTokensByUserId(UUID userId);
}
