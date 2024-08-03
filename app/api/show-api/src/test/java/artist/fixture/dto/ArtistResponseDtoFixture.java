package artist.fixture.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.artist.response.ArtistDetailPaginationDomainResponse;
import org.example.dto.artist.response.ArtistFilterTotalCountDomainResponse;
import org.example.dto.artist.response.ArtistPaginationDomainResponse;
import org.example.dto.artist.response.ArtistSimpleDomainResponse;

public class ArtistResponseDtoFixture {

    public static ArtistDetailPaginationDomainResponse artistDetailPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return ArtistDetailPaginationDomainResponse.builder()
            .data(artistSimpleDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static ArtistDetailPaginationDomainResponse emptyDataArtistDetailPaginationDomainResponse() {
        return ArtistDetailPaginationDomainResponse.builder()
            .data(List.of())
            .hasNext(false)
            .build();
    }

    public static ArtistFilterTotalCountDomainResponse artistFilterTotalCountDomainResponse(
        int totalCount
    ) {
        return new ArtistFilterTotalCountDomainResponse(totalCount);
    }

    public static ArtistPaginationDomainResponse artistPaginationDomainResponse(
        int size,
        boolean hasNext
    ) {
        return ArtistPaginationDomainResponse.builder()
            .data(artistSimpleDomainResponses(size))
            .hasNext(hasNext)
            .build();
    }

    public static ArtistPaginationDomainResponse emptyDataArtistPaginationDomainResponse() {
        return ArtistPaginationDomainResponse.builder()
            .data(List.of())
            .hasNext(false)
            .build();
    }

    public static List<ArtistSimpleDomainResponse> artistSimpleDomainResponses(
        int size
    ) {
        return IntStream.range(0, size)
            .mapToObj(i -> ArtistSimpleDomainResponse.builder()
                .id(UUID.randomUUID())
                .koreanName(i + "testKoreanName")
                .image(i + "testImage")
                .englishName(i + "testEnglishName")
                .build())
            .toList();
    }
}
