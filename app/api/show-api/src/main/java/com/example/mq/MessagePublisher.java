package com.example.mq;

import com.example.show.service.dto.request.ShowRelationArtistAndGenreServiceMessage;

public interface MessagePublisher {

    void publishShow(String topic, ShowRelationArtistAndGenreServiceMessage message);
}
