package org.example.repository.interest;

import org.example.dto.usershow.request.InterestShowPaginationDomainRequest;
import org.example.dto.usershow.response.InterestShowPaginationDomainResponse;

public interface InterestShowQuerydslRepository {

    InterestShowPaginationDomainResponse findInterestShowList(
        InterestShowPaginationDomainRequest request
    );
}
