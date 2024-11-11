package com.example.show.service;


import com.example.component.FileUploadComponent;
import com.example.pub.MessagePublisher;
import com.example.pub.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import com.example.show.service.dto.response.ShowInfoServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.entity.show.Show;
import org.example.usecase.ArtistUseCase;
import org.example.usecase.GenreUseCase;
import org.example.usecase.ShowAdminUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowAdminService {

    private final ShowAdminUseCase showAdminUseCase;
    private final GenreUseCase genreUseCase;
    private final ArtistUseCase artistUseCase;
    private final FileUploadComponent fileUploadComponent;
    private final MessagePublisher messagePublisher;

    public void save(ShowCreateServiceRequest showCreateServiceRequest) {
        String imageURL = fileUploadComponent.uploadFile("show", showCreateServiceRequest.post());

        Show show = showAdminUseCase.save(
            showCreateServiceRequest.toDomainRequest(imageURL)
        );

        messagePublisher.publishShow(
            "registerShow",
            ShowRelationArtistAndGenreServiceMessage.of(
                show.getId(),
                showCreateServiceRequest.artistIds(),
                showCreateServiceRequest.genreIds()
            )
        );
    }

    public List<ShowInfoServiceResponse> findShowDetailWithTicketingTimes() {
        var showWithTicketingTimesDomainResponses = showAdminUseCase.findShowDetailWithTicketingTimes();
        var artistNameWithShowIdDomainResponses = artistUseCase.findArtistNamesWithShowId();
        var genreNameWithShowIdDomainResponses = genreUseCase.findGenreNamesWithShowId();

        return ShowInfoServiceResponse.as(
            showWithTicketingTimesDomainResponses,
            artistNameWithShowIdDomainResponses,
            genreNameWithShowIdDomainResponses
        );

    }

    public ShowInfoServiceResponse findShowInfo(UUID id) {
        ShowInfoDomainResponse showInfoDomainResponse = showAdminUseCase.findShowInfo(id);

        return new ShowInfoServiceResponse(showInfoDomainResponse);
    }

    public void updateShow(UUID id, ShowUpdateServiceRequest showUpdateServiceRequest) {
        String imageUrl = fileUploadComponent.uploadFile("show", showUpdateServiceRequest.post());

        var artistIdsToPublish = showAdminUseCase.getArtistIdsToAdd(
            showUpdateServiceRequest.artistIds(),
            showAdminUseCase.findShowArtistsByShowId(id)
        );

        var genreIdsToPublish = showAdminUseCase.getGenreIdsToAdd(
            showUpdateServiceRequest.genreIds(),
            showAdminUseCase.findShowGenresByShowId(id)
        );

        showAdminUseCase.updateShow(
            id,
            showUpdateServiceRequest.toDomainRequest(imageUrl)
        );

        if (!artistIdsToPublish.isEmpty() || !genreIdsToPublish.isEmpty()) {
            messagePublisher.publishShow(
                "updateShow",
                ShowRelationArtistAndGenreServiceMessage.of(
                    id,
                    artistIdsToPublish,
                    genreIdsToPublish
                )
            );
        }
    }

    public void deleteShow(UUID id) {
        showAdminUseCase.deleteShow(id);
    }
}
