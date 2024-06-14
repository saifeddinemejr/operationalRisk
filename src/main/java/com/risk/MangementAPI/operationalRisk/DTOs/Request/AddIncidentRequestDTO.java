package com.risk.MangementAPI.operationalRisk.DTOs.Request;

import lombok.Data;


@Data
public class AddIncidentRequestDTO {
    private String detectionDate;
    private String declarationDate;
    private String occurrenceDate;
    private int frequency ;
    private int impact ;
    private String description ;
    private Long riskCategoryId;
    private Long procId;
    // You may need to add more fields here based on your requirements
}

