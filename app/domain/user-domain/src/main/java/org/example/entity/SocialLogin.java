package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.vo.SocialLoginType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
    name = "app_social_login",
    indexes = {
        @Index(
            name = "unq_social_login_type_identifier",
            columnList = "social_login_type, identifier",
            unique = true
        )
    }
)
public class SocialLogin extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialLoginType socialLoginType;

    @Column(nullable = false)
    private String identifier;

    @Column(nullable = false)
    private UUID userId;

    @Builder
    public SocialLogin(SocialLoginType socialLoginType, String identifier, UUID userId) {
        this.socialLoginType = socialLoginType;
        this.identifier = identifier;
        this.userId = userId;
    }
}
