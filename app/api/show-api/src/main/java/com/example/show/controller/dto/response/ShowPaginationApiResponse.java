package com.example.show.controller.dto.response;

import java.util.List;

public record ShowPaginationApiResponse(

    List<ShowSimpleApiResponse> shows
) {

}
