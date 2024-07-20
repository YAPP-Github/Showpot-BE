package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.vo.UserGender;
import org.example.vo.UserRole;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "fcm_token", nullable = false)
    private String fcmToken;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "gender", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserGender userGender;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @Builder
    public User(
        String nickname,
        String fcmToken
    ) {
        this.nickname = nickname;
        this.birth = LocalDate.of(0, 1, 1);
        this.fcmToken = fcmToken;
        this.userGender = UserGender.NOT_CHOSEN;
        this.userRole = UserRole.USER;
    }

    public void dirtyCheckFcmToken(String fcmToken) {
        if (fcmToken != null && !fcmToken.equals(this.fcmToken)) {
            this.fcmToken = fcmToken;
        }
    }

    public boolean isWithdrew() {
        return this.getIsDeleted();
    }
}