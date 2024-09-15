package com.example.show.service.dto.response;

import org.example.entity.usershow.InterestShow;

public record ShowInterestServiceResponse(
    boolean hasInterest
) {

    public static ShowInterestServiceResponse from(InterestShow interestShow) {
        return new ShowInterestServiceResponse(interestShow.hasInterest());
    }
}
