package show.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.component.FileUploadComponent;
import com.example.show.service.ShowAdminService;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import java.util.UUID;
import org.example.dto.show.request.ShowCreationDomainRequest;
import org.example.entity.show.Show;
import org.example.usecase.show.ShowUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import show.fixture.dto.ShowDtoFixture;

class ShowAdminServiceTest {

    private final ShowUseCase showUseCase = mock(ShowUseCase.class);
    private final FileUploadComponent fileUploadComponent = mock(FileUploadComponent.class);

    private final ShowAdminService showAdminService = new ShowAdminService(
        showUseCase, fileUploadComponent);

    @Test
    @DisplayName("공연은 업로드된 이미지 URL과 함께 생성된다.")
    void showCreateWithUploadedImageUrl() {
        //given
        ShowCreateServiceRequest showCreateServiceRequest = ShowDtoFixture.showCreateServiceRequest();
        given(
            fileUploadComponent.uploadFile(
                "artist",
                showCreateServiceRequest.post()
            )
        ).willReturn("test_imageUrl");
        ShowCreationDomainRequest request = showCreateServiceRequest.toDomainRequest("test_imageUrl");

        //when
        showAdminService.save(showCreateServiceRequest);

        //then
        verify(showUseCase, times(1)).save(request);
    }

    @Test
    @DisplayName("공연은 업로드된 이미지 URL과 함께 업데이트 된다.")
    void showUpdateWithUploadedImageUrl() {
        //given
        ShowUpdateServiceRequest showUpdateServiceRequest = ShowDtoFixture.showUpdateServiceRequest();
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
        verify(showUseCase, times(1)).updateShow(eq(showId), any(Show.class), anyList(), anyList());
    }

}
