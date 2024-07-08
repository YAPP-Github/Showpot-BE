package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.error.UserAdminError;
import org.example.entity.credential.SocialLoginCredential;
import org.example.exception.BusinessException;
import org.example.vo.UserGender;
import org.example.vo.UserRole;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_user")
public class User extends BaseEntity {

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "birth", nullable = false)
    private LocalDate birth = LocalDate.of(0, 1, 1);

    @Column(name = "fcm_token")
    private String fcmToken;

    @Embedded
    private SocialLoginCredential socialLoginCredential;

    @Column(name = "gender", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserGender userGender = UserGender.NOT_CHOSEN;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    private User(
        SocialLoginCredential socialLoginCredential
    ) {
        this.socialLoginCredential = socialLoginCredential;
        this.userRole = UserRole.USER;
    }

    public void validateUserRole() {
        if (!this.userRole.equals(UserRole.ADMIN)) {
            throw new BusinessException(UserAdminError.ADMIN_NOT_AUTHORITY_ERROR);
        }
    }
}