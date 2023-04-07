package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.analyze.youtubecommentanalyzeapi.global.utils.ObjectMapperSingleton;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.Map;

public class NaverCLOVA {
    private final String client_id;
    private final String client_secret;
    private final Map<String, String> api_urls;

    public NaverCLOVA(String client_id, String client_secret, Map<String, String> api_urls) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.api_urls = api_urls;
    }
    public String getEmotionApiUrl() {
        return api_urls.get("emotion");
    }
    public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", client_id);
        headers.set("X-NCP-APIGW-API-KEY", client_secret);
        headers.set("Content-Type", "application/json");
        return headers;
    }
    public HttpEntity getHttpEntity(Object object) {
        try {
            return new HttpEntity<>(ObjectMapperSingleton.getInstance().writeValueAsString(object), getHeaders());
        } catch (JsonProcessingException jsonProcessingException){
            throw new RuntimeException(jsonProcessingException);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }
}
