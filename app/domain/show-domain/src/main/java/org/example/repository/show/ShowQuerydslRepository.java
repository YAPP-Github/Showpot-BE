package org.example.repository.show;

import java.util.List;
import org.example.dto.artist.response.ShowInfoResponse;

public interface ShowQuerydslRepository {
    List<ShowInfoResponse> findAllShowInfos();
}
