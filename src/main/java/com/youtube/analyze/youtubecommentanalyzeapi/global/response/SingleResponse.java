package com.youtube.analyze.youtubecommentanalyzeapi.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class SingleResponse<T> {
   private T data;
}
