package com.example.show.service;


import com.example.component.FileUploadComponent;
import com.example.mq.MessagePublisher;
import com.example.show.error.ShowError;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowRelationArtistAndGenreServiceMessage;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import com.example.show.service.dto.response.ShowInfoServiceResponse;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.exception.BusinessException;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowAdminService {

    private final ShowUseCase showUseCase;
    private final FileUploadComponent fileUploadComponent;
    private final MessagePublisher messagePublisher;

    public void save(ShowCreateServiceRequest showCreateServiceRequest) {
        String imageURL = fileUploadComponent.uploadFile("show", showCreateServiceRequest.post());

        showUseCase.save(
            showCreateServiceRequest.toDomainRequest(imageURL)
        );

        messagePublisher.publishShow(
            "registerShow",
            ShowRelationArtistAndGenreServiceMessage.of(
                showCreateServiceRequest.artistIds(),
                showCreateServiceRequest.genreIds()
            )
        );
    }

    public List<ShowInfoServiceResponse> findAllShowInfos() {
        List<ShowInfoDomainResponse> showInfoDomainResponse = showUseCase.findAllShowInfos();
        return showInfoDomainResponse.stream()
            .map(ShowInfoServiceResponse::new)
            .toList();
    }

    public ShowInfoServiceResponse findShowInfo(UUID id) {
        ShowInfoDomainResponse showInfoDomainResponse;
        try {
            showInfoDomainResponse = showUseCase.findShowInfo(id);
        } catch (NoSuchElementException e) {
            throw new BusinessException(ShowError.ENTITY_NOT_FOUND);
        }

        return new ShowInfoServiceResponse(showInfoDomainResponse);
    }

    public void updateShow(UUID id, ShowUpdateServiceRequest showUpdateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("show", showUpdateServiceRequest.post());

        var artistIdsToPublish = showUseCase.getArtistIdsToAdd(
            showUpdateServiceRequest.artistIds(),
            showUseCase.findShowArtistsByShowId(id)
        );

        var genreIdsToPublish = showUseCase.getGenreIdsToAdd(
            showUpdateServiceRequest.genreIds(),
            showUseCase.findShowGenresByShowId(id)
        );

        try {
            showUseCase.updateShow(
                id,
                showUpdateServiceRequest.toDomainRequest(imageUrl)
            );
        } catch (NoSuchElementException e) {
            throw new BusinessException(ShowError.ENTITY_NOT_FOUND);
        }

        if (!artistIdsToPublish.isEmpty() || !genreIdsToPublish.isEmpty()) {
            messagePublisher.publishShow(
                "updateShow",
                ShowRelationArtistAndGenreServiceMessage.of(
                    artistIdsToPublish,
                    genreIdsToPublish
                )
            );
        }
    }

    public void deleteShow(UUID id) {
        try {
            showUseCase.deleteShow(id);
        } catch (NoSuchElementException e) {
            throw new BusinessException(ShowError.ENTITY_NOT_FOUND);
        }
    }
}
