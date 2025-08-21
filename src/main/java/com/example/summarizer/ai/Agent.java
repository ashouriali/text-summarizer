package com.example.summarizer.ai;

import com.example.summarizer.AppContext;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClient.CallResponseSpec;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Agent {

    private ChatClient chatClient = AppContext.getBean(ChatClient.class);
    protected abstract String loadSystemMessage();
    private SystemMessage systemMessage = null;
    private SystemMessage getSystemMessage() {
        if (systemMessage == null) {
            systemMessage = new SystemMessage(loadSystemMessage());
        }
        return systemMessage;
    }

    public final AssistantMessage replyToPrompt(List<Message> messages) {
        List<Message> allMessages = new ArrayList<>(List.<Message>of(getSystemMessage()));
        allMessages.addAll(messages);
        CallResponseSpec rawResponse = chatClient.prompt(new Prompt(allMessages)).call();
        return formatResponse(rawResponse);
    }

    private AssistantMessage formatResponse(CallResponseSpec responseSpec) {
        return Objects.requireNonNull(responseSpec.chatResponse()).getResult().getOutput();
    }

}