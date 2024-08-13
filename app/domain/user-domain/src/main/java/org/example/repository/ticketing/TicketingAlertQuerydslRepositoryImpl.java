package org.example.repository.ticketing;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TicketingAlertQuerydslRepositoryImpl implements TicketingAlertQuerydslRepository {

    private final JPAQueryFactory jpaQueryFactory;

}
