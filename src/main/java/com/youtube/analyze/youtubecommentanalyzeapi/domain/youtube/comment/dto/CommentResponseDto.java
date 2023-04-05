package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {
    private String kind;
    private String etag;
    private String id;
    private CommentSnippet snippet;

    public CommentResponseDto(String kind, String etag, String id, CommentSnippet snippet) {
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
    }

}
