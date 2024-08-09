package org.example.fixture;

import org.example.entity.User;
import org.example.vo.RandomNickname;

public class UserFixture {

    public static User randomNicknameUser() {
        return User.builder()
            .nickname(RandomNickname.makeRandomNickName())
            .fcmToken("testFcmToken")
            .build();
    }
}
