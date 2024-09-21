package artist.fixture.dto;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.request.ArtistFilterTotalCountServiceRequest;
import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import com.example.artist.vo.ArtistSortApiType;
import com.example.vo.SubscriptionStatusApiType;
import java.util.List;
import java.util.UUID;
import org.springframework.mock.web.MockMultipartFile;

public class ArtistRequestDtoFixture {

    private static final MockMultipartFile image = new MockMultipartFile(
        "image",
        "test_image.jpg",
        "image/jpeg",
        "test posterImageURL content".getBytes()
    );


    public static ArtistCreateServiceRequest artistCreateServiceRequest() {
        return ArtistCreateServiceRequest.builder()
            .koreanName("test_koreanName")
            .englishName("test_englishName")
            .image(image)
            .country("test_country")
            .artistGenderApiType(ArtistGenderApiType.MAN)
            .artistApiType(ArtistApiType.SOLO)
            .genreIds(List.of(UUID.randomUUID()))
            .build();
    }

    public static ArtistUpdateServiceRequest artistUpdateServiceRequest() {
        return ArtistUpdateServiceRequest.builder()
            .koreanName("test_koreanName")
            .englishName("test_englishName")
            .image(image)
            .country("test_country")
            .artistGenderApiType(ArtistGenderApiType.MAN)
            .artistApiType(ArtistApiType.SOLO)
            .genreIds(List.of(UUID.randomUUID()))
            .build();
    }

    public static ArtistSearchPaginationServiceRequest artistSearchPaginationServiceRequest(
        int size,
        String search
    ) {
        return ArtistSearchPaginationServiceRequest.builder()
            .cursor(0)
            .size(size)
            .search(search)
            .build();
    }

    public static ArtistFilterTotalCountServiceRequest artistFilterTotalCountServiceRequest() {
        return ArtistFilterTotalCountServiceRequest.builder()
            .artistGenderApiTypes(getArtistGenderApiTypes())
            .artistApiTypes(getArtistApiTypes())
            .genreIds(List.of(UUID.randomUUID()))
            .userId(UUID.randomUUID())
            .build();
    }

    public static ArtistSubscriptionPaginationServiceRequest artistSubscriptionPaginationServiceRequest(
        int size
    ) {
        return ArtistSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .size(size)
            .sortStandard(ArtistSortApiType.ENGLISH_NAME_ASC)
            .cursor(UUID.randomUUID())
            .userId(UUID.randomUUID())
            .build();
    }

    public static ArtistUnsubscriptionPaginationServiceRequest artistUnsubscriptionPaginationServiceRequest(
        int size
    ) {
        return ArtistUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .sortStandard(ArtistSortApiType.ENGLISH_NAME_ASC)
            .artistGenderApiTypes(getArtistGenderApiTypes())
            .artistApiTypes(getArtistApiTypes())
            .genreIds(List.of(UUID.randomUUID()))
            .userId(UUID.randomUUID())
            .cursor(UUID.randomUUID())
            .size(size)
            .build();
    }

    private static List<ArtistApiType> getArtistApiTypes() {
        return List.of(ArtistApiType.GROUP, ArtistApiType.SOLO);
    }

    private static List<ArtistGenderApiType> getArtistGenderApiTypes() {
        return List.of(ArtistGenderApiType.MAN, ArtistGenderApiType.WOMAN);
    }
}
