package com.youtube.analyze.youtubecommentanalyzeapi.global.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SliceResponseDto<T>{
    List<T> data;
    SliceInfo sliceInfo;
}
