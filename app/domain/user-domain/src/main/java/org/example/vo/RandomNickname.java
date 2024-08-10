package org.example.vo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RandomNickname {
    NICK(
        List.of(
            "기분좋은", "신바람나는", "상쾌한", "짜릿한", "자유로운",
            "당당한", "배부른", "수줍은", "멋있는", "잘생긴", "이쁜", "신비로운",
            "따뜻한", "신나는", "씩씩한", "순수한", "담백한", "활기찬",
            "단호한", "은은한", "우아한", "반짝이는", "행복한",
            "선명한", "애틋한", "깔끔한", "유쾌한", "신선한", "산뜻한",
            "쾌활한", "훈훈한", "몽환적인", "쿨한", "흥분된", "완벽한",
            "존경받는", "포근한", "느긋한", "달콤한", "차분한", "활달한",
            "고요한", "화사한", "청량한", "기분전환된", "평온한",
            "깔끔한", "로맨틱한", "모험적인", "영감이되는", "잔잔한",
            "산뜻한", "편안한"
        )
    ),

    NAME(
        List.of(
            "사자", "코끼리", "호랑이", "곰", "여우", "늑대", "너구리",
            "침팬치", "고릴라", "참새", "고슴도치", "강아지", "고양이",
            "거북이", "토끼", "앵무새", "하이에나", "돼지", "하마", "원숭이",
            "물소", "얼룩말", "치타", "악어", "기린", "수달", "염소",
            "다람쥐", "판다", "파이어폭스", "오소리", "밍크", "레서판다",
            "기러기", "펭귄", "오리", "카멜레온", "비둘기", "앵무새",
            "햄스터", "코뿔소", "푸들", "꿀벌", "돌고래", "별",
            "달팽이", "바다거북", "코알라", "타조", "하늘다람쥐",
            "기니피그", "조개"
        )
    );

    private final List<String> value;

    public static String makeRandomNickName() {
        return NICK.value.get(randomNumber()) + " "
            + NAME.value.get(randomNumber())
            + getUniqueNumber() + "님";
    }

    private static int randomNumber() {
        return ThreadLocalRandom.current().nextInt(51);
    }

    private static String getUniqueNumber() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1000));
    }
}
