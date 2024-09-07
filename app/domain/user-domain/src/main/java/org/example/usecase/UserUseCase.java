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
import org.example.repository.interest.InterestShowRepository;
import org.example.repository.subscription.artistsubscription.ArtistSubscriptionRepository;
import org.example.repository.subscription.genresubscription.GenreSubscriptionRepository;
import org.example.repository.ticketing.TicketingAlertRepository;
import org.example.repository.user.SocialLoginRepository;
import org.example.repository.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;
    private final SocialLoginRepository socialLoginRepository;
    private final ArtistSubscriptionRepository artistSubscriptionRepository;
    private final GenreSubscriptionRepository genreSubscriptionRepository;
    private final InterestShowRepository interestShowRepository;
    private final TicketingAlertRepository ticketingAlertRepository;

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

        User user = userRepository.findById(socialLogin.getUserId())
            .orElseThrow(NoSuchElementException::new);

        if (user.isWithdrew()) {
            throw new BusinessException(UserError.WITHDREW_USER_LOGIN);
        }

        user.dirtyCheckFcmToken(request.fcmToken());

        return user;
    }

    @Transactional
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        userRepository.delete(user);
        deleteAssociatedWith(user);
    }

    public UserProfileDomainResponse findUserProfile(UUID userId) {
        return userRepository.findUserProfileById(userId).orElseThrow(NoSuchElementException::new);
    }

    public String findUserFcmTokensByUserId(UUID userId) {
        return userRepository.findUserFcmTokensByUserId(userId).orElseThrow(NoSuchElementException::new);
    }

    private void deleteAssociatedWith(User user) {
        socialLoginRepository.deleteAllByUserId(user.getId());
        artistSubscriptionRepository.deleteAllByUserId(user.getId());
        genreSubscriptionRepository.deleteAllByUserId(user.getId());
        interestShowRepository.deleteAllByUserId(user.getId());
        ticketingAlertRepository.deleteAllByUserId(user.getId());
    }
}
