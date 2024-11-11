package show.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.component.FileUploadComponent;
import com.example.pub.MessagePublisher;
import com.example.pub.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.show.service.ShowAdminService;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import java.util.List;
import java.util.UUID;
import org.example.dto.show.request.ShowUpdateDomainRequest;
import org.example.fixture.domain.ShowArtistFixture;
import org.example.fixture.domain.ShowFixture;
import org.example.fixture.domain.ShowGenreFixture;
import org.example.usecase.ArtistUseCase;
import org.example.usecase.GenreUseCase;
import org.example.usecase.ShowAdminUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import show.fixture.dto.ShowRequestDtoFixture;

class ShowAdminServiceTest {

    private final ShowAdminUseCase showAdminUseCase = mock(ShowAdminUseCase.class);
    private final GenreUseCase genreUseCase = mock(GenreUseCase.class);
    private final ArtistUseCase artistUseCase = mock(ArtistUseCase.class);
    private final FileUploadComponent fileUploadComponent = mock(FileUploadComponent.class);
    private final MessagePublisher messagePublisher = mock(MessagePublisher.class);

    private final ShowAdminService showAdminService = new ShowAdminService(
        showAdminUseCase,
        genreUseCase,
        artistUseCase,
        fileUploadComponent,
        messagePublisher
    );

    @Test
    @DisplayName("공연은 업로드된 이미지 URL과 함께 생성된다.")
    void showCreateWithUploadedImageUrl() {
        //given
        ShowCreateServiceRequest showCreateServiceRequest = ShowRequestDtoFixture.showCreateServiceRequest();
        String url = "test_imageUrl";
        given(
            fileUploadComponent.uploadFile(
                "show",
                showCreateServiceRequest.post()
            )
        ).willReturn("test_imageUrl");
        given(
            showAdminUseCase.save(any())
        ).willReturn(ShowFixture.deafultShow());

        //when
        showAdminService.save(showCreateServiceRequest);

        //then
        verify(showAdminUseCase, times(1)).save(any());
    }

    @Test
    @DisplayName("공연 생성 후 연관된 아티스트, 장르 아이디로 메시지를 전송한다.")
    void showCreateWithPublishRelationArtistIdsAndGenreIds() {
        //given
        var showCreateServiceRequest = ShowRequestDtoFixture.showCreateServiceRequest();
        given(
            showAdminUseCase.save(any())
        ).willReturn(ShowFixture.deafultShow());

        //when
        showAdminService.save(showCreateServiceRequest);

        //then
        verify(messagePublisher, times(1)).publishShow(
            anyString(),
            any(ShowRelationArtistAndGenreServiceMessage.class)
        );
    }

    @Test
    @DisplayName("공연은 업로드된 이미지 URL과 함께 업데이트 된다.")
    void showUpdateWithUploadedImageUrl() {
        //given
        ShowUpdateServiceRequest showUpdateServiceRequest = ShowRequestDtoFixture.showUpdateServiceRequest();
        UUID showId = UUID.randomUUID();
        given(
            fileUploadComponent.uploadFile(
                "show",
                showUpdateServiceRequest.post()
            )
        ).willReturn("test_imageUrl");

        //when
        showAdminService.updateShow(showId, showUpdateServiceRequest);

        //then
        verify(showAdminUseCase, times(1)).updateShow(eq(showId),
            any(ShowUpdateDomainRequest.class));
    }

    @Test
    @DisplayName("공연 업데이트 후 새로 연관된 아티스트, 장르 아이디로 메시지를 전송한다.")
    void showUpdateWithPublishNewRelationArtistIdsAndGenreIds() {
        //given
        ShowUpdateServiceRequest showUpdateServiceRequest = ShowRequestDtoFixture.showUpdateServiceRequest();
        UUID showId = UUID.randomUUID();
        var showArtists = ShowArtistFixture.showArtists(3);
        given(
            showAdminUseCase.findShowArtistsByShowId(showId)
        ).willReturn(
            showArtists
        );
        given(
            showAdminUseCase.getArtistIdsToAdd(
                showUpdateServiceRequest.artistIds(),
                showArtists
            )
        ).willReturn(List.of(UUID.randomUUID()));

        var showGenres = ShowGenreFixture.showGenres(3);
        given(
            showAdminUseCase.findShowGenresByShowId(showId)
        ).willReturn(
            showGenres
        );
        given(
            showAdminUseCase.getGenreIdsToAdd(
                showUpdateServiceRequest.genreIds(),
                showGenres
            )
        ).willReturn(List.of(UUID.randomUUID()));

        //when
        showAdminService.updateShow(showId, showUpdateServiceRequest);

        //then
        verify(messagePublisher, times(1)).publishShow(
            anyString(),
            any(ShowRelationArtistAndGenreServiceMessage.class)
        );
    }

}
