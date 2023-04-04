package com.youtube.analyze.youtubecommentanalyzeapi.global.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    FILE_NOT_SUPPORTED(400,"파일 형식이 지원되지 않습니다.");


    @Getter
    private final int code;

    @Getter
    private final String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
