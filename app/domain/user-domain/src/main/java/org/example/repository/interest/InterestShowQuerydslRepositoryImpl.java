package org.example.repository.interest;

import static org.example.entity.QInterestShow.interestShow;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;
import org.example.entity.InterestShow;
import org.example.util.SliceUtil;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InterestShowQuerydslRepositoryImpl implements InterestShowQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public InterestShowPaginationDomainResponse findInterestShowList(InterestShowPaginationDomainRequest request) {
        var data = jpaQueryFactory.selectFrom(interestShow)
            .where(getInterestShowPaginationConditions(request))
            .orderBy(
                interestShow.updatedAt.desc(),
                interestShow.id.asc()
            )
            .limit(request.size() + 1)
            .fetch();

        Slice<InterestShow> interestShowSlice = SliceUtil.makeSlice(request.size(), data);

        return InterestShowPaginationDomainResponse.builder()
            .hasNext(interestShowSlice.hasNext())
            .data(interestShowSlice.getContent())
            .build();
    }

    private BooleanExpression getInterestShowPaginationConditions(InterestShowPaginationDomainRequest request) {
        BooleanExpression whereConditions = interestShow.userId.eq(request.userId())
            .and(interestShow.isDeleted.isFalse());

        if (request.cursorId() == null) {
            return whereConditions;
        }

        Tuple cursor = jpaQueryFactory
            .select(interestShow.id, interestShow.updatedAt)
            .from(interestShow)
            .where(interestShow.showId.eq(request.cursorId())
                .and(interestShow.userId.eq(request.userId())))
            .fetchOne();

        if (cursor == null) {
            return whereConditions;
        }

        LocalDateTime cursorValue = cursor.get(interestShow.updatedAt);
        UUID cursorId = cursor.get(interestShow.id);

        whereConditions = whereConditions.and(
            interestShow.updatedAt.lt(cursorValue)
                .or(
                    interestShow.updatedAt.eq(cursorValue)
                        .and(interestShow.id.gt(cursorId))
                )
        );

        return whereConditions;
    }
}
