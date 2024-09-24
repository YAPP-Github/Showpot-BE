package com.example.artist.sub.listener;

import com.example.artist.service.ArtistAdminService;
import com.example.artist.sub.converter.SubscriptionMessageConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Qualifier(value = "artistCreateListener")
public class ArtistCreateListener implements MessageListener {

    private final ArtistAdminService artistAdminService;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        var request = SubscriptionMessageConverter.toArtistCreateMessage(message);
        artistAdminService.saveArtist(request.toServiceRequest());
    }
}
