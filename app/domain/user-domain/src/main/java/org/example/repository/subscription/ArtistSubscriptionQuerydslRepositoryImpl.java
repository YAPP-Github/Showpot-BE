package org.example.repository.subscription;

import static org.example.entity.QArtistSubscription.artistSubscription;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.entity.ArtistSubscription;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistSubscriptionQuerydslRepositoryImpl implements ArtistSubscriptionQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ArtistSubscription> findSubscriptionList(UUID userId) {
        return jpaQueryFactory.selectFrom(artistSubscription)
            .where(artistSubscription.userId.eq(userId)
                .and(artistSubscription.isDeleted.eq(false))
            ).fetch();
    }
}
