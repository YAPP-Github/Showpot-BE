package org.example.util;

public final class ValidatorCursorSize {

    private static final Integer DEFAULT_SIZE = 30;

    public static int getDefaultSize(Integer size) {
        if (size == null) {
            return DEFAULT_SIZE;
        }

        return size;
    }
}
