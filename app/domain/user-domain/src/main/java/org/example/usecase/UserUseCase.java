package org.example.usecase;

import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.LoginDomainRequest;
import org.example.dto.response.UserProfileDomainResponse;
import org.example.entity.SocialLogin;
import org.example.entity.User;
import org.example.error.UserError;
import org.example.exception.BusinessException;
import org.example.repository.user.SocialLoginRepository;
import org.example.repository.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;
    private final SocialLoginRepository socialLoginRepository;

    @Transactional
    public User createNewUser(User user, SocialLogin socialLogin) {
        while (userRepository.existsByNickname(user.getNickname())) {
            user.changeNickname();
        }

        socialLoginRepository.save(socialLogin);
        return userRepository.save(user);
    }

    @Transactional
    public User findUser(LoginDomainRequest request) {
        SocialLogin socialLogin = socialLoginRepository.findBySocialLoginTypeAndIdentifier(
            request.socialLoginType(),
            request.identifier()
        ).orElseThrow(NoSuchElementException::new);

        User user = findByIdOrElseThrow(socialLogin.getUserId());

        if (user.isWithdrew()) {
            throw new BusinessException(UserError.WITHDREW_USER_LOGIN);
        }

        user.dirtyCheckFcmToken(request.fcmToken());

        return user;
    }

    public User deleteUser(UUID userId) {
        User user = findByIdOrElseThrow(userId);
        userRepository.delete(user);
        socialLoginRepository.deleteAllByUserId(user.getId());
        return user;
    }

    public UserProfileDomainResponse findUserProfile(UUID userId) {
        return userRepository.findUserProfileById(userId).orElseThrow(NoSuchElementException::new);
    }

    public String findUserFcmTokensByUserId(UUID userId) {
        return userRepository.findUserFcmTokensByUserId(userId).orElseThrow(NoSuchElementException::new);
    }

    public User findByIdOrElseThrow(UUID userId) {
        return userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }
}
