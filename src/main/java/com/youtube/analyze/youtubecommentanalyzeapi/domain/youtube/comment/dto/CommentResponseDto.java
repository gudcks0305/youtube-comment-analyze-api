package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto;

import com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.EmotionRequestDto;
import lombok.Getter;

@Getter
public class CommentResponseDto extends EmotionRequestDto {
    private String kind;
    private String etag;
    private String id;
    private CommentSnippet snippet;

    public CommentResponseDto(String kind, String etag, String id, CommentSnippet snippet) {
        super(snippet.getTextOriginal());
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
    }

}
