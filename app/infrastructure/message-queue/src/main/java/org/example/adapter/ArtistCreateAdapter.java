package org.example.adapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.message.ArtistWithGenreCreateInfraMessage;
import org.example.port.ArtistCreatePort;
import org.example.port.dto.request.ArtistCreatePortRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ArtistCreateAdapter implements ArtistCreatePort {

    private final RedisTemplate<String, Object> template;

    @Override
    public void createArtist(String topic, ArtistCreatePortRequest request) {
        var infraMessage = ArtistWithGenreCreateInfraMessage.from(request);

        template.convertAndSend(topic, infraMessage);
        log.info("Message published successfully to topic: {}", topic);
        log.info("Message Contents ( ArtistWithGenreCreateInfraMessage : {})", infraMessage);
    }
}
