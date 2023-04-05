package com.youtube.analyze.youtubecommentanalyzeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화 공통 data 생성일, 수정일 자동화
public class YoutubeCommentAnalyzeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubeCommentAnalyzeApiApplication.class, args);
    }

}
