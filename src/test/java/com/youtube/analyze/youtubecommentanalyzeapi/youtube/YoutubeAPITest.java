package com.youtube.analyze.youtubecommentanalyzeapi.youtube;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.YoutubeAPI;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentResponseDto;
import com.youtube.analyze.youtubecommentanalyzeapi.global.utils.ObjectMapperSingleton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
class YoutubeAPITest {
    @Autowired
    private YoutubeAPI youtubeAPI;

/*    @Test
    @DisplayName("YoutubeAPI commentThread request 테스트")
    void commentThreadRequestTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String videoId = "acqm9mM1P6o";
        RestTemplate restTemplate = new RestTemplate();
        String url = youtubeAPI.getCommentThreadsUrl() + "?part=snippet,replies&videoId=" + videoId + "&key=" + youtubeAPI.getApiKey();
        Map commentResponseDtos = restTemplate.getForObject(url, Map.class);
        System.out.println(ObjectMapperSingleton.getObjectMapper().valueToTree(commentResponseDtos));
    }*/
}
