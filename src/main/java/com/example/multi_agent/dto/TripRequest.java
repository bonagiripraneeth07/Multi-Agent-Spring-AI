package com.example.multi_agent.dto;

import java.math.BigDecimal;

public record TripRequest (
    String destination,
    int numberOfDays,
    BigDecimal budget,
    String preferences
){

}
