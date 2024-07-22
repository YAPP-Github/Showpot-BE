package org.example.util;

public final class StringNormalizer {

    private StringNormalizer() {
    }

    public static String removeWhitespaceAndLowerCase(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

}
