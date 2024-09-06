package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Object address) {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object address) {
        Map<String, List<String>> result = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            MinLength minLength = field.getAnnotation(MinLength.class);
            if (notNull != null || minLength != null) {
                field.setAccessible(true);
                List<String> errorMses = new ArrayList<>();
                try {
                    if (field.get(address) == null) {
                        errorMses.add("can not be null");
                    } else if (minLength != null && field.get(address).toString().length() < minLength.minLength()) {
                        errorMses.add("length less than " + minLength.minLength());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (errorMses.size() > 0) {
                    result.put(field.getName(), errorMses);
                }
            }
        }

        return result;
// END
    }
}