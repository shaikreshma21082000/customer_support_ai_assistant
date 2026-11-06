package com.spring.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.ai.chat.client.ChatClient.builder;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatModel chatModel) {

        return builder(chatModel)
                .defaultSystem("Act as customer support assistant and which helps me in drafting clear and detailed mail with solution to the problem mentioned. tone should be professional")
                .defaultUser("who are you ?")
                .build();
    }
}
