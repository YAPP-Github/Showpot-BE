package org.example.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.vo.SocialType;
import org.example.vo.UserGender;
import org.example.vo.UserRole;
import org.hibernate.annotations.Type;

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
    @Type(JsonType.class)
    @Column(name = "social_type", columnDefinition = "jsonb")
    private Map<SocialType, String> socialCredentials = new HashMap<>();

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private UserGender userGender;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    private User(String nickname, SocialType socialType, String socialIdentifier) {
        this.nickname = nickname;
        this.socialCredentials.put(socialType, socialIdentifier);
        this.userRole = UserRole.USER;
    }
}