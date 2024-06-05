package org.example.security.token;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.example.repository.RedisRepository;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshTokenProcessor {

    private final JWTHandler jwtHandler;
    private final JWTGenerator jwtGenerator;
    private final RedisRepository redisRepository;

    public TokenParam reissueToken(HttpServletRequest request) {
        String refreshToken = jwtHandler.extractRefreshToken(request);
        UserParam userParam = jwtHandler.extractUserFrom(refreshToken);
        TokenParam newTokenParam = jwtGenerator.generate(userParam, new Date());

        redisRepository.save(userParam.userId().toString(), newTokenParam.refreshToken());
        return newTokenParam;
    }
}
