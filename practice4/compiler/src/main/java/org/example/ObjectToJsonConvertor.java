package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ObjectToJsonConvertor {
    public String convertToJson(Object obj) {
        try {
            checkIfSerializable(obj);
            initializeObject(obj);
            return getJsonString(obj);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private void checkIfSerializable(Object object) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception("The object to serialize is null");
        }

        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new Exception("The class "
                    + clazz.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }

    private void initializeObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(InitMethod.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), (String) field.get(object));
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    private String getKey(Field field) {
        JsonElement jsonElement = field.getAnnotation(JsonElement.class);
        if (!jsonElement.key().isEmpty()) {
            return jsonElement.key();
        } else {
            return field.getName();
        }
    }
}
