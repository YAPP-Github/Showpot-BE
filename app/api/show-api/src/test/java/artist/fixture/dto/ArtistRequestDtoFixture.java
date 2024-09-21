package artist.fixture.dto;

import com.example.artist.service.dto.request.ArtistSearchPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistSubscriptionPaginationServiceRequest;
import com.example.artist.service.dto.request.ArtistUnsubscriptionPaginationServiceRequest;
import com.example.vo.SubscriptionStatusApiType;
import java.util.UUID;
import org.springframework.mock.web.MockMultipartFile;

public class ArtistRequestDtoFixture {

    private static final MockMultipartFile image = new MockMultipartFile(
        "image",
        "test_image.jpg",
        "image/jpeg",
        "test posterImageURL content".getBytes()
    );


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

    public static ArtistSubscriptionPaginationServiceRequest artistSubscriptionPaginationServiceRequest(
        int size
    ) {
        return ArtistSubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.SUBSCRIBED)
            .size(size)
            .cursor(UUID.randomUUID())
            .userId(UUID.randomUUID())
            .build();
    }

    public static ArtistUnsubscriptionPaginationServiceRequest artistUnsubscriptionPaginationServiceRequest(
        int size
    ) {
        return ArtistUnsubscriptionPaginationServiceRequest.builder()
            .subscriptionStatusApiType(SubscriptionStatusApiType.UNSUBSCRIBED)
            .userId(UUID.randomUUID())
            .cursor(UUID.randomUUID())
            .size(size)
            .build();
    }
}
