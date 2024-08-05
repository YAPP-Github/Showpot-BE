package org.example.util;

import java.util.List;

public class ValidateStatus {

    public static <T> List<T> checkNullOrEmpty(List<T> list) {
        return (list == null || list.isEmpty()) ? List.of() : list;
    }

}
