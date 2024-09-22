package org.example.fixture;

import java.lang.reflect.Field;
import java.util.UUID;

public class ReflectionUtils {

    public static void setSuperClassId(Object target, String filed, UUID id) {
        try {
            Field field = target.getClass().getSuperclass().getDeclaredField(filed);
            field.setAccessible(true);
            field.set(target, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setId(Object target, String fieldName, UUID id) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
