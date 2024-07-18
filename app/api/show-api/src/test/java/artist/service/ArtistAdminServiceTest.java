package artist.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import artist.fixture.dto.ArtistDtoFixture;
import com.example.artist.service.ArtistAdminService;
import com.example.artist.service.dto.request.ArtistCreateServiceRequest;
import com.example.artist.service.dto.request.ArtistUpdateServiceRequest;
import com.example.component.FileUploadComponent;
import java.util.UUID;
import org.example.entity.artist.Artist;
import org.example.usecase.artist.ArtistUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArtistAdminServiceTest {

    private final ArtistUseCase artistUseCase = mock(ArtistUseCase.class);
    private final FileUploadComponent fileUploadComponent = mock(FileUploadComponent.class);

    private final ArtistAdminService artistAdminService = new ArtistAdminService(
        artistUseCase, fileUploadComponent);

    @Test
    @DisplayName("아티스트는 업로드된 이미지 URL과 함께 생성된다.")
    void artistCreateWithUploadedImageUrl() {
        //given
        ArtistCreateServiceRequest artistCreateServiceRequest = ArtistDtoFixture.artistCreateServiceRequest();
        given(
            fileUploadComponent.uploadFile(
                "artist",
                artistCreateServiceRequest.image()
            )
        ).willReturn("test_imageUrl");

        //when
        artistAdminService.save(artistCreateServiceRequest);

        //then
        verify(artistUseCase, times(1)).save(any(Artist.class), anyList());
    }

    @Test
    @DisplayName("아티스트는 업로드된 이미지 URL과 함께 업데이트 된다.")
    void artistUpdateWithUploadedImageUrl() {
        //given
        ArtistUpdateServiceRequest artistUpdateServiceRequest = ArtistDtoFixture.artistUpdateServiceRequest();
        UUID artistId = UUID.randomUUID();
        given(
            fileUploadComponent.uploadFile(
                "artist",
                artistUpdateServiceRequest.image()
            )
        ).willReturn("test_imageUrl");

        //when
        artistAdminService.updateArtist(artistId, artistUpdateServiceRequest);

        //then
        verify(artistUseCase, times(1)).updateArtist(eq(artistId), any(Artist.class), anyList());
    }

}
