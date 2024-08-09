package org.example.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.QueryTest;
import org.example.entity.SocialLogin;
import org.example.entity.User;
import org.example.fixture.SocialLoginFixture;
import org.example.fixture.UserFixture;
import org.example.repository.user.SocialLoginRepository;
import org.example.repository.user.UserRepository;
import org.example.vo.SocialLoginType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserRepositoryTest extends QueryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SocialLoginRepository socialLoginRepository;

    @Test
    @DisplayName("사용자의 프로필을 가져올 수 있다.")
    void findUserProfile() {
        //given
        User user = UserFixture.randomNicknameUser();
        userRepository.save(user);

        SocialLogin socialLogin = SocialLoginFixture.socialLogin(SocialLoginType.KAKAO,
            user.getId());
        socialLoginRepository.save(socialLogin);

        //when
        var result = userRepository.findUserProfileById(user.getId()).orElseThrow();

        //then
        assertThat(result).isNotNull();
    }
}
