package com.spring.ai.service;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final ChatClient chatClient;

    @Value("classpath:/promptTemplate/HrPromptTemplate.st")
    Resource prompt;



    public String getResponse(String name, String message) {
        return chatClient.prompt()
                .user(promptUserSpec -> promptUserSpec.text(prompt)
                        .param("name", name)
                        .param("message", message)
                )
                .call()
                .content();
    }
}
