package com.example.show.controller.dto.request;

import com.example.show.controller.dto.response.SeatInfoApiResponse;
import com.example.show.controller.dto.response.TicketingInfoApiResponse;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.web.multipart.MultipartFile;

public record ShowUpdateApiForm(

    @NotBlank(message = "공연 제목은 필수 요청값 입니다.")
    String title,

    @NotBlank(message = "공연 내용은 필수 요청값 입니다.")
    String content,

    @NotNull(message = "공연 날짜는 필수 요청값 입니다.")
    LocalDate date,

    @NotNull(message = "공연 장소는 필수 요청값 입니다.")
    String location,

    @NotNull(message = "공연 포스터는 필수 요청값 입니다.")
    MultipartFile post,

    @NotNull(message = "공연 좌석 타입은 필수 요청값 입니다.")
    List<String> seatTypes,

    @NotNull(message = "공연 좌석별 가격은 필수 요청값 입니다.")
    List<Integer> pricesPerSeatType,

    @NotNull(message = "공연 티켓 오픈 시간은 필수 요청값 입니다.")
    LocalDateTime ticketOpenTime,

    @NotNull(message = "티켓팅 예약 사이트명은 필수 요청값 입니다.")
    List<String> ticketBookingSites,

    @NotNull(message = "티켓팅 예약 사이트 URL는 필수 요청값 입니다.")
    List<String> ticketingSiteUrls,

    @NotNull(message = "아티스트 ID는 필수 요청값 입니다.")
    List<UUID> artistIds,

    @NotNull(message = "장르 ID는 필수 요청값 입니다.")
    List<UUID> genreIds
) {

    public ShowUpdateServiceRequest toServiceRequest() {
        return ShowUpdateServiceRequest.builder()
            .title(title)
            .content(content)
            .date(date)
            .location(location)
            .post(post)
            .seatInfoApiResponse(getSeatPriceApiType())
            .ticketingInfoApiResponse(getTicketingApiType())
            .artistIds(artistIds)
            .genreIds(genreIds)
            .build();
    }

    private SeatInfoApiResponse getSeatPriceApiType() {
        Map<String, Integer> priceInformation = IntStream.range(0, seatTypes.size())
            .boxed()
            .collect(Collectors.toMap(seatTypes::get, pricesPerSeatType::get));
        return new SeatInfoApiResponse(priceInformation);
    }

    private TicketingInfoApiResponse getTicketingApiType() {
        Map<String, String> ticketingInformation = IntStream.range(0, ticketBookingSites.size())
            .boxed()
            .collect(Collectors.toMap(ticketBookingSites::get, ticketingSiteUrls::get));
        return new TicketingInfoApiResponse(ticketOpenTime, ticketingInformation);
    }

}
