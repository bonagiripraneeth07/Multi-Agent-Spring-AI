package com.example.multi_agent.dto;

import java.util.List;

public record ResearchResult (
      List<String> attractions,
      List<String> travelTips,
      List<String>foodOptions
){
}
