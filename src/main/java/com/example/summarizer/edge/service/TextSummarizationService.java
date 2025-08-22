package com.example.summarizer.edge.service;

import com.example.summarizer.edge.dto.TextSummarizationDto;
import com.example.summarizer.edge.model.TextSummarizationEntity;
import com.example.summarizer.ai.TextSummarizerAgent;
import com.example.summarizer.edge.repository.TextSummarizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TextSummarizationService {
    private final TextSummarizationRepository textSummarizationRepository;
    private final TextSummarizerAgent textSummarizerAgent;

    public TextSummarizationDto summarizeText(TextSummarizationDto textSummarizationDto) {
        AssistantMessage message = textSummarizerAgent.replyToPrompt(List.of(new UserMessage(textSummarizationDto.getText())));
        TextSummarizationEntity textSummarizationEntity = TextSummarizationEntity.builder()
                .originalText(textSummarizationDto.getText())
                .summarizedText(message.getText())
                .build();
        return textSummarizationRepository.save(textSummarizationEntity).toDto();
    }

    public List<TextSummarizationDto> getAllTextSummarizations(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return textSummarizationRepository.findAll(pageable)
                .stream()
                .map(TextSummarizationEntity::toDto)
                .collect(Collectors.toList());
    }

}
