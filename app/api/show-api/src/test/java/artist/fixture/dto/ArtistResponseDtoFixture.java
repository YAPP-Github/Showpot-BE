package artist.fixture.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.artist.response.ArtistDetailPaginationDomainResponse;
import org.example.dto.artist.response.ArtistFilterDomainResponse;
import org.example.dto.artist.response.ArtistFilterPaginationDomainResponse;
import org.example.dto.artist.response.ArtistFilterTotalCountDomainResponse;
import org.example.dto.artist.response.ArtistSubscriptionDomainResponse;
import org.example.dto.artist.response.ArtistSubscriptionPaginationDomainResponse;
import org.example.dto.artist.response.SimpleArtistDomainResponse;

public class ArtistResponseDtoFixture {

    public static ArtistDetailPaginationDomainResponse artistDetailPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return ArtistDetailPaginationDomainResponse.builder()
            .data(simpleArtistDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static ArtistDetailPaginationDomainResponse emptyDataArtistDetailPaginationDomainResponse() {
        return ArtistDetailPaginationDomainResponse.builder()
            .data(List.of())
            .hasNext(false)
            .build();
    }

    public static List<SimpleArtistDomainResponse> simpleArtistDomainResponses(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> SimpleArtistDomainResponse.builder()
                .id(UUID.randomUUID())
                .koreanName(i + "testKoreanName")
                .image(i + "testImage")
                .englishName(i + "testEnglishName")
                .build())
            .toList();
    }

    public static ArtistFilterPaginationDomainResponse artistFilterPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return ArtistFilterPaginationDomainResponse.builder()
            .data(artistFilterDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static ArtistFilterPaginationDomainResponse emptyDataArtistFilterPaginationDomainResponse() {
        return ArtistFilterPaginationDomainResponse.builder()
            .data(List.of())
            .hasNext(false)
            .build();
    }

    public static ArtistFilterTotalCountDomainResponse artistFilterTotalCountDomainResponse(
        int totalCount
    ) {
        return new ArtistFilterTotalCountDomainResponse(totalCount);
    }

    public static ArtistSubscriptionPaginationDomainResponse artistSubscriptionPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return ArtistSubscriptionPaginationDomainResponse.builder()
            .data(artistSubscriptionDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static List<ArtistFilterDomainResponse> artistFilterDomainResponses(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> ArtistFilterDomainResponse.builder()
                .id(UUID.randomUUID())
                .koreanName(i + "testKoreanName")
                .image(i + "testImage")
                .englishName(i + "testEnglishName")
                .build())
            .toList();
    }

    public static List<ArtistSubscriptionDomainResponse> artistSubscriptionDomainResponses(
        int size
    ) {
        return IntStream.range(0, size)
            .mapToObj(i -> ArtistSubscriptionDomainResponse.builder()
                .id(UUID.randomUUID())
                .koreanName(i + "testKoreanName")
                .image(i + "testImage")
                .englishName(i + "testEnglishName")
                .build())
            .toList();
    }
}
