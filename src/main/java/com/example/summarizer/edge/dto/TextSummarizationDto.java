package com.example.summarizer.edge.dto;

import com.example.summarizer.common.exception.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextSummarizationDto {
    private String text;
    private String summary;
    private String id;

    public void validate() throws GeneralException {
        if (text == null || text.isEmpty())
            throw new GeneralException("Original text must not be null", HttpStatus.BAD_REQUEST);
        if (summary != null) throw new GeneralException("Summarized must be null", HttpStatus.BAD_REQUEST);
        if (id != null) throw new GeneralException("Id must be null", HttpStatus.BAD_REQUEST);
    }
}
