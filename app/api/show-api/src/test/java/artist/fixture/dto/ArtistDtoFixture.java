package artist.fixture.dto;

import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.artist.vo.ArtistApiType;
import com.example.artist.vo.ArtistGenderApiType;
import java.util.List;
import java.util.UUID;
import org.springframework.mock.web.MockMultipartFile;

public class ArtistDtoFixture {

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
}
