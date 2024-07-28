package org.example.util;

public final class StringNormalizer {

    private StringNormalizer() {
    }

    public static String removeWhitespaceAndLowerCase(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력 값 입니다.");
        }

        return input.replaceAll("\\s+", "").toLowerCase();
    }

}
