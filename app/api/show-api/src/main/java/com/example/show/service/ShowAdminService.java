package com.example.show.service;


import com.example.component.FileUploadComponent;
import com.example.show.controller.dto.response.ShowWithTicketingTimesServiceResponse;
import com.example.show.error.ShowError;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
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

    public void save(ShowCreateServiceRequest showCreateServiceRequest) {
        String imageURL = fileUploadComponent.uploadFile("show", showCreateServiceRequest.post());

        showUseCase.save(
            showCreateServiceRequest.toDomainRequest(imageURL)
        );
    }

    public List<ShowWithTicketingTimesServiceResponse> findShowDetailWithTicketingTimes() {
        return showUseCase.findShowDetailWithTicketingTimes().stream()
            .map(ShowWithTicketingTimesServiceResponse::new)
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

        try {
            showUseCase.updateShow(
                id,
                showUpdateServiceRequest.toDomainRequest(imageUrl)
            );
        } catch (NoSuchElementException e) {
            throw new BusinessException(ShowError.ENTITY_NOT_FOUND);
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
