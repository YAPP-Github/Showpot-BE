package artist.fixture.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.example.dto.artist.response.ArtistDetailPaginationDomainResponse;
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
}
