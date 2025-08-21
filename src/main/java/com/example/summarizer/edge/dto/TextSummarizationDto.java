package com.example.summarizer.edge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextSummarizationDto {
   private String originalText;
   private String summarizedText;
   private String id;
}
