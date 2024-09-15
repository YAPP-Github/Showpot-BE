package org.example.repository.subscription.genresubscription;


import static org.example.entity.usershow.QGenreSubscription.genreSubscription;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.usershow.GenreSubscription;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GenreSubscriptionQuerydslRepositoryImpl implements GenreSubscriptionQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<GenreSubscription> findSubscriptionsByUserId(UUID userId) {
        return jpaQueryFactory
            .selectFrom(genreSubscription)
            .where(genreSubscription.userId.eq(userId)
                .and(genreSubscription.isDeleted.isFalse())
            )
            .fetch();
    }
}
