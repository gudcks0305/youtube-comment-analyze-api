package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class YouTubeAPIRequester {
    private final YoutubeAPI youtubeAPI;

    public List<CommentResponseDto> getCommentThreads(String videoId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = youtubeAPI.getCommentThreadsUrl() + "?part=snippet&videoId=" + videoId + "&key=" + youtubeAPI.getApiKey();
        CommentResponseDto[] commentResponseDtos = null;
        try {
            commentResponseDtos = restTemplate.getForObject(url, CommentResponseDto[].class);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return List.of(Objects.requireNonNull(commentResponseDtos));
    }
}
