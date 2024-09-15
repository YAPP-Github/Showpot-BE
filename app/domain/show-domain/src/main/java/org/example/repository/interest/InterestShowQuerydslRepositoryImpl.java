package org.example.repository.interest;


import static org.example.entity.usershow.QInterestShow.interestShow;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.dto.usershow.request.InterestShowPaginationDomainRequest;
import org.example.dto.usershow.response.InterestShowPaginationDomainResponse;
import org.example.entity.usershow.InterestShow;
import org.example.util.SliceUtil;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InterestShowQuerydslRepositoryImpl implements InterestShowQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public InterestShowPaginationDomainResponse findInterestShowList(
        InterestShowPaginationDomainRequest request
    ) {
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

    private BooleanExpression getInterestShowPaginationConditions(
        InterestShowPaginationDomainRequest request
    ) {
        BooleanExpression whereConditions = interestShow.userId.eq(request.userId())
            .and(interestShow.isDeleted.isFalse());

        if (request.cursorId() != null && request.cursorValue() != null) {
            whereConditions = whereConditions.and(
                interestShow.updatedAt.lt(request.cursorValue())
                    .or(
                        interestShow.updatedAt.eq(request.cursorValue())
                            .and(interestShow.id.gt(request.cursorId()))
                    )
            );
        }

        return whereConditions;
    }
}
