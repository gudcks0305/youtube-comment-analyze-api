package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube;

import java.util.Map;

public class YoutubeAPI {
    private final String apiKey;
    private final Map<String ,String> urls;

    public YoutubeAPI(String apiKey, Map<String, String> urls) {
        this.apiKey = apiKey;
        this.urls = urls;
    }


    public String getCommentThreadsUrl() {
        return urls.get("commentThreads");
    }
    public String getApiKey() {
        return apiKey;
    }
}
