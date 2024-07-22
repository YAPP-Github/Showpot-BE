package com.example.show.service;

import com.example.show.service.dto.response.ShowSearchServiceResponse;
import lombok.RequiredArgsConstructor;
import org.example.usecase.show.ShowUseCase;
import org.example.util.StringNormalizer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowUseCase showUseCase;

    public ShowSearchServiceResponse searchShow(String name) {
        String showName = StringNormalizer.removeWhitespaceAndLowerCase(name);
        return new ShowSearchServiceResponse(showUseCase.searchShow(showName));
    }

}
