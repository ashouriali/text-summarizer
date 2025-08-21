package com.example.summarizer.ai;

import com.example.summarizer.common.utils.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class TextSummarizerAgent extends Agent {

    @Override
    protected String loadSystemMessage() {
        return FileUtils.getContentOfFile("ai/text_summarizer.agent");
    }
}
