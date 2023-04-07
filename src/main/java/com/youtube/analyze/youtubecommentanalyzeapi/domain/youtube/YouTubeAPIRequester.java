package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentResponseDto;
import com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto.CommentSnippet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class YouTubeAPIRequester {
    private final YoutubeAPI youtubeAPI;

    public List<CommentResponseDto> getCommentThreads(String videoId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = youtubeAPI.getCommentThreadsUrl() + "?part=snippet&videoId=" + videoId + "&key=" + youtubeAPI.getApiKey();
        Map response = null;
        try {
            response = restTemplate.getForObject(url, Map.class);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        List<Object> items = (List<Object>) response.get("items");
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Object item : items) {
            Map<String, Object> itemMap = (Map<String, Object>) item;
            Map<String, Object> snippet = (Map<String, Object>) itemMap.get("snippet");
            Map<String, Object> topLevelComment = (Map<String, Object>) snippet.get("topLevelComment");
            Map<String, Object> topLevelCommentSnippet = (Map<String, Object>) topLevelComment.get("snippet");
            String kind = (String) itemMap.get("kind");
            String etag = (String) itemMap.get("etag");
            String id = (String) itemMap.get("id");
            String authorDisplayName = (String) topLevelCommentSnippet.get("authorDisplayName");
            String textOriginal = (String) topLevelCommentSnippet.get("textOriginal");
            int likeCount = (int) topLevelCommentSnippet.get("likeCount");
            CommentSnippet commentSnippet = new CommentSnippet(authorDisplayName, textOriginal, likeCount);
            CommentResponseDto commentResponseDto = new CommentResponseDto(kind, etag, id, commentSnippet);
            commentResponseDtos.add(commentResponseDto);
        }
        return commentResponseDtos;
    }
}
