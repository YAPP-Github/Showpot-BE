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
import org.example.vo.SocialCredentials;
import org.example.vo.SocialLoginType;
import org.example.vo.UserGender;
import org.example.vo.UserRole;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_user")
public class User extends BaseEntity {

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "fcm_token")
    private String fcmToken;

    @Embedded
    private SocialCredentials socialCredentials = new SocialCredentials();

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private UserGender userGender;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    private User(String nickname, SocialLoginType socialLoginType, String socialIdentifier) {
        this.nickname = nickname;
        this.socialCredentials.put(socialLoginType, socialIdentifier);
        this.userRole = UserRole.USER;
    }
}