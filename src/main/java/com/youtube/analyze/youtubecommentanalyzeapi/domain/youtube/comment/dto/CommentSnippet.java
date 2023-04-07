package com.youtube.analyze.youtubecommentanalyzeapi.domain.youtube.comment.dto;

import lombok.Getter;

@Getter
public class CommentSnippet {
    private String authorDisplayName;

    private String textOriginal;

    public CommentSnippet(String authorDisplayName, String textOriginal, int likeCount) {
        this.authorDisplayName = authorDisplayName;
        this.textOriginal = textOriginal;
        this.likeCount = likeCount;
    }

    private int likeCount;

}
