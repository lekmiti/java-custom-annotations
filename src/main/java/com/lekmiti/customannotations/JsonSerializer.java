package com.lekmiti.customannotations;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class JsonSerializer implements Serializer {

    private OutputWriter jsonWriter = new OutputWriter();

    private String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(joining(","));
        return "{" + elementsString + "}";
    }

    private static String getSerializedKey(Field field) {
        if (field.isAnnotationPresent(JsonKey.class)) {
            String annotationValue = field.getAnnotation(JsonKey.class).value();
            return annotationValue.isEmpty() ? field.getName() : annotationValue;
        }
        return field.getName();
    }


    @Override
    public String serialize(Object object) throws JsonSerializeException, IOException {
        try {
            Class<?> objectClass = object.getClass();
            Map<String, String> jsonMap = new HashMap<String, String>();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (! field.isAnnotationPresent(IgnoreField.class)) {
                    jsonMap.put(getSerializedKey(field), field.get(object).toString());
                }
            }
            String jsonString = toJsonString(jsonMap);
            System.out.println(jsonString);
            jsonWriter.writeInFile(jsonString);
            return toJsonString(jsonMap);
        } catch (IllegalAccessException e) {
            throw new JsonSerializeException(e.getMessage());
        }
    }
}
