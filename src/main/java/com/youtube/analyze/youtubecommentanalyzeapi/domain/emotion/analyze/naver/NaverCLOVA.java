package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

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
}
