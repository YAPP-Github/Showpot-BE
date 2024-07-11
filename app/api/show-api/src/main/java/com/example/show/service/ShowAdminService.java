package com.example.show.service;


import com.example.show.component.FileUploadComponent;
import com.example.show.service.dto.request.ShowCreateServiceRequest;
import lombok.RequiredArgsConstructor;
import org.example.entity.show.Show;
import org.example.usecase.show.ShowUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowAdminService {

    private final ShowUseCase showUseCase;
    private final FileUploadComponent fileUploadComponent;

    public void save(ShowCreateServiceRequest showCreateServiceRequest) {
        String image = fileUploadComponent.uploadFile("show", showCreateServiceRequest.post());
        Show show = showCreateServiceRequest.toShow(image);

        showUseCase.save(
            show,
            showCreateServiceRequest.artistIds(),
            showCreateServiceRequest.genreIds()
        );
    }

}
