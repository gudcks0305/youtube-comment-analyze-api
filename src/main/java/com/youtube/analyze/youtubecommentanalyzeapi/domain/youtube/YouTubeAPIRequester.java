package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class YouTubeAPIRequester {
   private final YoutubeAPI youtubeAPI;

    public List<CommentResponseDto> getCommentThreads(String videoId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = youtubeAPI.getCommentThreadsUrl() + "?part=snippet&videoId=" + videoId + "&key=" + youtubeAPI.getApiKey();
        CommentResponseDto[] commentResponseDtos = restTemplate.getForObject(url, CommentResponseDto[].class);
        return List.of(commentResponseDtos);
    }
}
