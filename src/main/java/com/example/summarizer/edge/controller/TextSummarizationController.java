package com.example.summarizer.edge.controller;

import com.example.summarizer.edge.dto.ResponseDto;
import com.example.summarizer.edge.dto.TextSummarizationDto;
import com.example.summarizer.edge.service.TextSummarizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gw/v1/texts")
@RequiredArgsConstructor
public class TextSummarizationController {
    private final TextSummarizationService textSummarizationService;

    @PostMapping("/summarize")
    public ResponseDto<TextSummarizationDto> summarizeText(@RequestBody TextSummarizationDto textSummarizationDto) {
        TextSummarizationDto summarizedText = textSummarizationService.summarizeText(textSummarizationDto);
        return ResponseDto.of(summarizedText);
    }

    @GetMapping
    public ResponseDto<List<TextSummarizationDto>> getAllTextSummarizations() {
        return ResponseDto.of(textSummarizationService.getAllTextSummarizations());
    }
}
