package com.example.show.service;


import com.example.component.FileUploadComponent;
import com.example.publish.MessagePublisher;
import com.example.publish.message.ShowRelationArtistAndGenreServiceMessage;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import com.example.show.service.dto.request.ShowUpdateServiceRequest;
import com.example.show.service.dto.response.ShowInfoServiceResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.show.response.ShowInfoDomainResponse;
import org.example.usecase.artist.ArtistUseCase;
import org.example.usecase.genre.GenreUseCase;
import org.example.usecase.show.ShowAdminUseCase;
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

        showAdminUseCase.save(
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

    public List<ShowInfoServiceResponse> findShowDetailWithTicketingTimes() {
        var showWithTicketingTimesDomainResponses = showAdminUseCase.findShowDetailWithTicketingTimes();
        var artistKoreanNameWithShowIdDomainResponses = artistUseCase.findArtistKoreanNamesWithShowId();
        var genreNameWithShowIdDomainResponses = genreUseCase.findGenreNamesWithShowId();

        return ShowInfoServiceResponse.as(
            showWithTicketingTimesDomainResponses,
            artistKoreanNameWithShowIdDomainResponses,
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
