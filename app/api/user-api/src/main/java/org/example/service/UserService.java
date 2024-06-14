package org.example.service;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.repository.RedisRepository;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.token.JWTGenerator;
import org.example.service.dto.request.LoginServiceRequest;
import org.example.usecase.UserUseCase;
import org.example.vo.UserRoleApiType;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserUseCase userUseCase;
    private final JWTGenerator jwtGenerator;
    private final RedisRepository redisRepository;

    public TokenParam login(final LoginServiceRequest loginServiceRequest) {
        User createdUser = userUseCase.save(loginServiceRequest.toLoginServiceDto().toUser());
        UserParam userParam = UserParam.builder()
            .userId(createdUser.getId())
            .role(UserRoleApiType.valueOf(createdUser.getUserRole().name()))
            .build();
        TokenParam tokenParam = jwtGenerator.generate(userParam, new Date());

        redisRepository.save(userParam.userId().toString(), tokenParam.refreshToken());

        return tokenParam;
    }

    public String findNickname(final User user) {
        return userUseCase.findNickName(user);
    }
}
