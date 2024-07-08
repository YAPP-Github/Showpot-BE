package org.example.usecase;

import lombok.RequiredArgsConstructor;
import org.error.UserAdminError;
import org.example.entity.User;
import org.example.exception.BusinessException;
import org.example.repository.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdminUseCase {

    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByNickname(username)
            .orElseThrow(() -> new BusinessException(UserAdminError.ENTITY_NOT_FOUND_ERROR));
    }
}
