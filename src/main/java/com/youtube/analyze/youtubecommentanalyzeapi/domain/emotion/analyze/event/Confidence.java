package com.youtube.analyze.youtubecommentanalyzeapi.domain.emotion.analyze.event;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Confidence {
   private double negative;
    private double neutral;
    private double positive;

   public Confidence(double negative, double neutral, double positive) {
      this.negative = negative;
      this.neutral = neutral;
      this.positive = positive;
   }
}
