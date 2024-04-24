package com.risk.MangementAPI.operationalRisk.DTOs.Request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddIncidentRequestDTO {
    private String detectionDate;
    private String declarationDate;
    private String occurrenceDate;
    // You may need to add more fields here based on your requirements
}
