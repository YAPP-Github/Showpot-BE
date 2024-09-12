package org.example.repository.interest;

import org.example.dto.request.InterestShowPaginationDomainRequest;
import org.example.dto.response.InterestShowPaginationDomainResponse;

public interface InterestShowQuerydslRepository {

    InterestShowPaginationDomainResponse findInterestShowList(
        InterestShowPaginationDomainRequest request
    );
}
