package com.youtube.analyze.youtubecommentanalyzeapi.global.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperSingleton {
   private static final ObjectMapper objectMapper = new ObjectMapper();
   public static ObjectMapper getObjectMapper() {
       return objectMapper;
   }
}