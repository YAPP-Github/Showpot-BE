package show.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.component.FileUploadComponent;
import com.example.mq.MessagePublisher;
import com.example.show.service.ShowAdminService;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowRelationArtistAndGenreServiceMessage;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import java.util.List;
import java.util.UUID;
import org.example.dto.show.request.ShowUpdateDomainRequest;
import org.example.fixture.domain.ShowArtistFixture;
import org.example.fixture.domain.ShowGenreFixture;
import org.example.usecase.show.ShowUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import show.fixture.dto.ShowRequestDtoFixture;

class ShowAdminServiceTest {

    private final ShowUseCase showUseCase = mock(ShowUseCase.class);
    private final FileUploadComponent fileUploadComponent = mock(FileUploadComponent.class);
    private final MessagePublisher messagePublisher = mock(MessagePublisher.class);

    private final ShowAdminService showAdminService = new ShowAdminService(
        showUseCase,
        fileUploadComponent,
        messagePublisher
    );

    @Test
    @DisplayName("공연은 업로드된 이미지 URL과 함께 생성된다.")
    void showCreateWithUploadedImageUrl() {
        //given
        ShowCreateServiceRequest showCreateServiceRequest = ShowRequestDtoFixture.showCreateServiceRequest();
        given(
            fileUploadComponent.uploadFile(
                "artist",
                showCreateServiceRequest.post()
            )
        ).willReturn("test_imageUrl");

        //when
        showAdminService.save(showCreateServiceRequest);

        //then
        verify(showUseCase, times(1)).save(any());
    }

    @Test
    @DisplayName("공연 생성 후 연관된 아티스트, 장르 아이디로 메시지를 전송한다.")
    void showCreateWithPublishRelationArtistIdsAndGenreIds() {
        //given
        var showCreateServiceRequest = ShowRequestDtoFixture.showCreateServiceRequest();
        var showCreationDomainRequest = showCreateServiceRequest.toDomainRequest(
            "test_imageUrl"
        );
        willDoNothing().given(showUseCase).save(showCreationDomainRequest);

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
                "artist",
                showUpdateServiceRequest.post()
            )
        ).willReturn("test_imageUrl");

        //when
        showAdminService.updateShow(showId, showUpdateServiceRequest);

        //then
        verify(showUseCase, times(1)).updateShow(eq(showId), any(ShowUpdateDomainRequest.class));
    }

    @Test
    @DisplayName("공연 업데이트 후 새로 연관된 아티스트, 장르 아이디로 메시지를 전송한다.")
    void showUpdateWithPublishNewRelationArtistIdsAndGenreIds() {
        //given
        ShowUpdateServiceRequest showUpdateServiceRequest = ShowRequestDtoFixture.showUpdateServiceRequest();
        UUID showId = UUID.randomUUID();
        var showArtists = ShowArtistFixture.showArtists(3);
        given(
            showUseCase.findShowArtistsByShowId(showId)
        ).willReturn(
            showArtists
        );
        given(
            showUseCase.getArtistIdsToAdd(
                showUpdateServiceRequest.artistIds(),
                showArtists
            )
        ).willReturn(List.of(UUID.randomUUID()));

        var showGenres = ShowGenreFixture.showGenres(3);
        given(
            showUseCase.findShowGenresByShowId(showId)
        ).willReturn(
            showGenres
        );
        given(
            showUseCase.getGenreIdsToAdd(
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
