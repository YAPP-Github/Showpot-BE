package org.example.util;

import java.lang.reflect.Field;
import java.util.UUID;

public final class ReflectionUtil {

    public static void setSuperClassId(Object target, UUID id) {
        try {
            Field field = target.getClass().getSuperclass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(target, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
