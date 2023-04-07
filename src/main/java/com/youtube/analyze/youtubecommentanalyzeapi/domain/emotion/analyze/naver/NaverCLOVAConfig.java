package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Configuration
public class NaverCLOVAConfig {
    @Value("${naver.clova.clientId:dummy}")
    private String client_id;
    @Value("${naver.clova.clientSecret:dummy}")
    private String client_secret;
    private final Map<String, String> api_urls = Map.of(
            "emotion", "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"
    );

    @Bean
    public NaverCLOVA naverCLOVA() {
        return new NaverCLOVA(client_id, client_secret, api_urls);
    }
}
