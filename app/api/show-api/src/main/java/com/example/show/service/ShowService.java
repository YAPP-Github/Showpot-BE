package com.example.show.service;

import com.example.show.service.dto.param.ShowSearchPaginationServiceParam;
import com.example.show.service.dto.request.ShowSearchPaginationServiceRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.dto.response.PaginationServiceResponse;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowUseCase showUseCase;

    public PaginationServiceResponse<ShowSearchPaginationServiceParam> searchShow(
        ShowSearchPaginationServiceRequest request
    ) {
        var response = showUseCase.searchShow(request.toDomainRequest());

        List<ShowSearchPaginationServiceParam> data = response.data().stream()
            .map(ShowSearchPaginationServiceParam::new)
            .toList();

        return PaginationServiceResponse.of(data, response.hasNext());
    }

}
