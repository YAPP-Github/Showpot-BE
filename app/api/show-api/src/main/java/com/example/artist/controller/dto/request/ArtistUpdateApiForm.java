package com.example.artist.controller.dto.request;

import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public record ArtistUpdateApiForm(
    @NotBlank(message = "아티스트의 한국 이름은 필수 요청값 입니다.")
    String koreanName,

    @NotBlank(message = "아티스트의 영어 이름은 필수 요청값 입니다.")
    String englishName,

    @NotNull(message = "아티스트의 이미지는 필수 요청값 입니다.")
    MultipartFile image,

    @NotBlank(message = "아티스트의 국적은 필수 요청값 입니다.")
    String country,

    @NotNull(message = "아티스트의 성별은 필수 요청값 입니다.")
    ArtistGenderApiType artistGenderApiType,

    @NotNull(message = "아티스트의 타입은 필수 요청값 입니다.")
    ArtistApiType artistApiType,

    @NotNull(message = "아티스트의 장르Id는 필수 요청값 입니다.")
    List<UUID> genreIds
) {

    public ArtistUpdateServiceRequest toArtistUpdateServiceRequest() {
        return ArtistUpdateServiceRequest.builder()
            .koreanName(koreanName)
            .englishName(englishName)
            .image(image)
            .country(country)
            .artistGenderApiType(artistGenderApiType)
            .artistApiType(artistApiType)
            .genreIds(genreIds)
            .build();

    }

}
