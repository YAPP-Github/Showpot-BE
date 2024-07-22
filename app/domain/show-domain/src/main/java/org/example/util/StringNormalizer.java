package org.example.util;

import org.example.exception.BusinessException;
import org.example.exception.GlobalError;

public final class StringNormalizer {

    private StringNormalizer() {
    }

    public static String removeWhitespaceAndLowerCase(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new BusinessException(GlobalError.INPUT_INVALID_VALUE);
        }

        return input.replaceAll("\\s+", "").toLowerCase();
    }

}
