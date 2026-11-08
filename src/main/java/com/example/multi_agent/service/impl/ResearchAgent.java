package com.example.multi_agent.service.impl;

import com.example.multi_agent.dto.ResearchResult;
import com.example.multi_agent.dto.TripRequest;
import com.example.multi_agent.service.Agent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ResearchAgent implements Agent<TripRequest, ResearchResult> {
    private final ChatClient chatClient;

    public ResearchAgent(
            @Qualifier("researchChatClient") ChatClient chatClient
    ) {
        this.chatClient = chatClient;
    }


    @Override
    public String name() {
        return "research agent";
    }

    @Override
    public ResearchResult execute(TripRequest request) {

        return chatClient
                .prompt()
                .user(user-> user.text(
"""
        Research a trip using these requirements:
        
                                 Destination: {destination}
                                 Number of days: {days}
                                 Total budget: {budget}
                                 Preferences: {preferences}
        
                                 Return suitable attractions, food options
                                 and important travel tips.
                                 """)
                             .param("destination", request.destination())
                             .param("days", request.numberOfDays())
                             .param("budget", request.budget())
                             .param("preferences", request.preferences()))
                .call()
                .entity(ResearchResult.class);
    }
}
