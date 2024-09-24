package org.example.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
@Slf4j
public class RedisSubErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("Redis Sub error occurred - message : {}, cause : {} ", t.getMessage(), t.getCause());
    }
}
