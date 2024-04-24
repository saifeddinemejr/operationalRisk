package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Incident;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncidentResponseDTO {
    private Long id;
    private LocalDateTime detectionDate;
    private LocalDateTime declarationDate;
    private LocalDateTime occurrenceDate;
    // You may need to add more fields here based on your requirements

    public IncidentResponseDTO toDto(Incident incident) {
        this.id = incident.getId();
        this.detectionDate = incident.getDetectionDate();
        this.declarationDate = incident.getDeclarationDate();
        this.occurrenceDate = incident.getOccuranceDate();
        // You may need to map more fields here based on your Incident entity
        return this;
    }
}
