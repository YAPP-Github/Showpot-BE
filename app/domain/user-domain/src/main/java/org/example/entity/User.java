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
import org.example.entity.credential.SocialCredentials;
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
    private SocialCredentials socialCredentials;

    @Column(name = "gender", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserGender userGender = UserGender.NONE;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    private User(
        SocialCredentials socialCredentials
    ) {
        this.socialCredentials = socialCredentials;
        this.userRole = UserRole.USER;
    }
}