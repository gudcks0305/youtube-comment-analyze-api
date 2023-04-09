package com.youtube.analyze.youtubecommentanalyzeapi.reflection;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event.Confidence;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver.NaverEmotionResponseDto;
import com.youtube.analyze.youtubecommentanalyzeapi.global.utils.ReflectionUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class ReflectionTest {
    @Test
    void emotionResponseTest() throws ClassNotFoundException {
        Object object = new NaverEmotionResponseDto(
                "content",
                new NaverEmotionResponseDto.Document(
                        "sentiment",
                        new Confidence(0.1, 0.2, 0.3)
                )
        );
        Field[] fields = object.getClass().getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();

        ReflectionUtils.recursiveGetFieldNamesWithOutObject(fieldNames, object.getClass());
        System.out.println(fieldNames);
    }
    @Test
    void emotionResponseTest2()  {
        Object object = new NaverEmotionResponseDto(
                "content",
                new NaverEmotionResponseDto.Document(
                        "sentiment",
                        new Confidence(0.1, 0.2, 0.3)
                )
        );
        List<String> fieldNames = new ArrayList<>();
        ReflectionUtils.recursiveGetFieldNamesWithOutObject(fieldNames, object.getClass());
        Map<String, String> fieldNamesMap = fieldNames.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
        ReflectionUtils.recursiveSetValueByFieldNames(object, fieldNamesMap);
        System.out.println(fieldNamesMap);
    }
}
