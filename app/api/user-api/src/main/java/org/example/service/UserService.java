package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.usecase.UserUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserUseCase userUseCase;

    public User signUp(final User user) {
        return userUseCase.save(user);
    }

    public String findNickname(final User user) {
        return userUseCase.findNickName(user);
    }
}
