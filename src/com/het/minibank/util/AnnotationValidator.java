package com.het.minibank.util;

import com.het.minibank.model.annotation.MaxLength;
import com.het.minibank.model.annotation.Positive;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnnotationValidator {

    public static String[] validate(Object obj) {

        List<String> errors = new ArrayList<>();

        Class<?> clazz = obj.getClass();
        while (clazz != null && clazz != Object.class) {

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                try {
                    Object value = field.get(obj);

                    if (field.isAnnotationPresent(Positive.class)
                            && value instanceof Number number) {
                        if (number.longValue() <= 0) {
                            errors.add(field.getAnnotation(Positive.class).message());
                        }
                    }

                    if (field.isAnnotationPresent(MaxLength.class)
                            && value instanceof String text) {
                        int max = field.getAnnotation(MaxLength.class).value();
                        if (text.length() > max) {
                            errors.add("length must be <= " + max);
                        }
                    }
                } catch (IllegalAccessException e) {
                    errors.add("cannot read field " + field.getName());
                }
            }

            clazz = clazz.getSuperclass();
        }

        return errors.toArray(new String[0]);
    }
}
