package com.example.show.service;

import com.example.component.ViewCountComponent;
import com.example.show.service.dto.param.ShowSearchPaginationServiceParam;
import com.example.show.service.dto.request.ShowPaginationServiceRequest;
import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import com.example.show.service.dto.response.ShowDetailServiceResponse;
import com.example.show.service.dto.response.ShowPaginationServiceResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.dto.show.response.ShowDetailDomainResponse;
import org.example.usecase.InterestShowUseCase;
import org.example.usecase.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowUseCase showUseCase;
    private final InterestShowUseCase interestShowUseCase;
    private final ViewCountComponent viewCountComponent;

    public ShowDetailServiceResponse getShow(UUID userId, UUID showId, String deviceToken) {
        ShowDetailDomainResponse showDetail = showUseCase.findShowDetail(showId);

        boolean isInterested =
            userId != null && interestShowUseCase.findInterestShow(showId, userId).isPresent();

        if (viewCountComponent.validateViewCount(showId, deviceToken)) {
            showUseCase.view(showId);
        }

        return ShowDetailServiceResponse.from(showDetail, isInterested);
    }

    public PaginationServiceResponse<ShowSearchPaginationServiceParam> searchShow(
        ShowSearchPaginationServiceRequest request
    ) {
        var response = showUseCase.searchShow(request.toDomainRequest());

        List<ShowSearchPaginationServiceParam> data = response.data().stream()
            .map(ShowSearchPaginationServiceParam::from)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

    public PaginationServiceResponse<ShowPaginationServiceResponse> findShows(
        ShowPaginationServiceRequest request
    ) {
        LocalDateTime now = LocalDateTime.now();
        var response = showUseCase.findShows(request.toDomainRequest(now));

        var data = response.data().stream()
            .map(domainResponse ->
                ShowPaginationServiceResponse.of(domainResponse, now)
            )
            .toList();

        return PaginationServiceResponse.of(
            data,
            response.hasNext()
        );
    }
}
