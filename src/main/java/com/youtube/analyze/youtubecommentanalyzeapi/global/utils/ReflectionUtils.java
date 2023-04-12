package com.youtube.analyze.youtubecommentanalyzeapi.global.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class ReflectionUtils {
    /**
     * @param fieldNames
     * @param clazz
     * Object 내부의 primitive type과 String , Wrraper type 의 field 이름을 가져오는 메소드
     * 재귀 호출로 내부의 내부의 primitive type과 String , Wrraper type 의 field 이름을 가져온다.
     */
    public static void recursiveGetFieldNamesWithOutObject(List<String> fieldNames, Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType().isPrimitive() || field.getType().getName().startsWith("java.lang")) {
                fieldNames.add(field.getName());
                continue;
            }
            recursiveGetFieldNamesWithOutObject(fieldNames, field.getType());
        }
    }

    // object 의 내부 object 의  field 값을 가져오는 메소드
    public static void recursiveSetValueByFieldNames(Object object, Map<String, String> fieldNamesAndValue) {
        if (object == null) {
            return;
        }
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getType().isPrimitive() || field.getType().getName().startsWith("java.lang")) {
                if (fieldNamesAndValue.containsKey(field.getName())) {
                    try {
                        field.setAccessible(true);
                        // field 에서 실제 값 가져오기
                        Object value = field.get(object);
                        // field 에 실제 값 넣기
                        fieldNamesAndValue.put(field.getName(), value.toString());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                continue;
            }
            try {
                field.setAccessible(true);
                recursiveSetValueByFieldNames(field.get(object), fieldNamesAndValue);
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }
}
