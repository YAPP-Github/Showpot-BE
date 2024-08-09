package org.example.repository.user;

import static org.example.entity.QSocialLogin.socialLogin;
import static org.example.entity.QUser.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.UserProfileDomainResponse;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQuerydslRepositoryImpl implements UserQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<UserProfileDomainResponse> findUserProfileById(UUID userId) {
        return Optional.ofNullable(jpaQueryFactory
            .select(
                Projections.constructor(
                    UserProfileDomainResponse.class,
                    user.nickname,
                    socialLogin.socialLoginType
                )
            )
            .from(user)
            .join(socialLogin).on(socialLogin.userId.eq(userId), socialLogin.isDeleted.isFalse())
            .where(user.id.eq(userId), user.isDeleted.isFalse())
            .fetchFirst()
        );
    }
}
