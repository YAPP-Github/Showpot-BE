package com.example.show.service;


import com.example.component.FileUploadComponent;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import com.example.show.service.dto.response.ShowInfoServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.response.ShowInfoResponse;
import org.example.entity.show.Show;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowAdminService {

    private final ShowUseCase showUseCase;
    private final FileUploadComponent fileUploadComponent;

    public void save(ShowCreateServiceRequest showCreateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("show", showCreateServiceRequest.post());
        Show show = showCreateServiceRequest.toShowWithImageUrl(imageUrl);

        showUseCase.save(
            show,
            showCreateServiceRequest.artistIds(),
            showCreateServiceRequest.genreIds()
        );
    }

    public List<ShowInfoServiceResponse> findAllShowInfos() {
        List<ShowInfoResponse> showInfoResponses = showUseCase.findAllShowInfos();
        return showInfoResponses.stream()
            .map(ShowInfoServiceResponse::new)
            .toList();
    }

    public ShowInfoServiceResponse findShowInfo(UUID id) {
        ShowInfoResponse showInfoResponse = showUseCase.findShowInfo(id);
        return new ShowInfoServiceResponse(showInfoResponse);
    }

    public void updateShow(UUID id, ShowUpdateServiceRequest showUpdateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("show", showUpdateServiceRequest.post());
        Show show = showUpdateServiceRequest.toShowWithImageUrl(imageUrl);

        showUseCase.updateShow(id, show, showUpdateServiceRequest.artistIds(),
            showUpdateServiceRequest.genreIds());
    }

    public void deleteShow(UUID id) {
        showUseCase.deleteShow(id);
    }
}
