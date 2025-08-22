package com.example.summarizer.edge.model;

import com.example.summarizer.edge.dto.TextSummarizationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "text_summaries")
public class TextSummarizationEntity {
    @Id
    private String id;
    private String originalText;
    private String summarizedText;

    public TextSummarizationDto toDto() {
        return TextSummarizationDto.builder().id(id).text(originalText).summary(summarizedText).build();
    }
}
