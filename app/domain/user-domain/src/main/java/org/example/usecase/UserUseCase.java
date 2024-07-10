package org.example.usecase;

import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.example.dto.request.LoginDomainRequest;
import org.example.entity.SocialLogin;
import org.example.entity.User;
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
        socialLoginRepository.save(socialLogin);
        return userRepository.save(user);
    }

    public User findUser(LoginDomainRequest request) {
        SocialLogin socialLogin = socialLoginRepository.findBySocialLoginTypeAndIdentifier(
            request.socialLoginType(),
            request.identifier()
        ).orElseThrow(NoSuchElementException::new);

        User user = userRepository.findById(socialLogin.getUserId())
            .orElseThrow(NoSuchElementException::new);

        user.dirtyCheckFcmToken(request.fcmToken());

        return user;
    }

    public String findNickName(final User user) {
        return userRepository.findNicknameById(user.getId()).orElseThrow();
    }
}
