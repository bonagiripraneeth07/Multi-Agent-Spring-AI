package com.example.multi_agent.dto;

public record TripPlanningResponse(
        TripRequest request,
        ResearchResult research,
        BudgetResult budget,
        ItineraryResult itinerary,
        ReviewResult review,
        String status

) {

}
