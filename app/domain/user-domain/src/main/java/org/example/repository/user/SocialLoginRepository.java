package org.example.repository.user;

import java.util.Optional;
import java.util.UUID;
import org.example.entity.SocialLogin;
import org.example.vo.SocialLoginType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialLoginRepository extends JpaRepository<SocialLogin, UUID> {

    Optional<SocialLogin> findBySocialLoginTypeAndIdentifier(
        SocialLoginType socialLoginType,
        String identifier
    );

    void deleteAllByUserId(UUID userId);
}
