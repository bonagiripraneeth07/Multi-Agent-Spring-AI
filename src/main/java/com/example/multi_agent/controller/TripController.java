package com.example.multi_agent.controller;

import com.example.multi_agent.dto.TripPlanningResponse;
import com.example.multi_agent.dto.TripRequest;
import com.example.multi_agent.service.impl.TripPlanningOrchestrator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/trips")
public class TripController {
    private final TripPlanningOrchestrator orchestrator;

    public TripController(TripPlanningOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }
    @PostMapping("/plan")
    public ResponseEntity<TripPlanningResponse>plan(@RequestBody TripRequest request){
        TripPlanningResponse response = orchestrator.plan(request);
        return ResponseEntity.ok(response);
    }

}
