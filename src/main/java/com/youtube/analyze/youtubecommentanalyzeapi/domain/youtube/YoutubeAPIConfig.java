package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class YoutubeAPIConfig {
    @Value("${google.cloud.youtube.data.key:dummy}")
    private String apiKey;

    private final Map<String, String> urls = Map.of(
            "commentThreads", "https://www.googleapis.com/youtube/v3/commentThreads",
            "comments", "https://www.googleapis.com/youtube/v3/comments"
    );

    @Bean
    public YoutubeAPI youtubeAPI() {
        return new YoutubeAPI(apiKey, urls);
    }
}
