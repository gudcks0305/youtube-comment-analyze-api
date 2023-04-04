package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.naver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class NaverCLOVAConfig {
    /*
    * #!/usr/bin/env python3
 #-*- codig: utf-8 -*-
 import sys
 import requests
 import json
 client_id = "X-NCP-APIGW-API-KEY-ID"
 client_secret = "X-NCP-APIGW-API-KEY"
 url="https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"
 headers = {
     "X-NCP-APIGW-API-KEY-ID": client_id,
     "X-NCP-APIGW-API-KEY": client_secret,
     "Content-Type": "application/json"
 }
    * */
    private String client_id = "X-NCP-APIGW-API-KEY-ID";
    private String client_secret = "X-NCP-APIGW-API-KEY";
    private final Map<String, String> api_urls = Map.of(
            "emotion", "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"
    );

    @Bean
    public NaverCLOVA naverCLOVA() {
        return new NaverCLOVA(client_id, client_secret, api_urls);
    }
}
