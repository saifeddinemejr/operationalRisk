package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Incident;
import com.risk.MangementAPI.operationalRisk.Model.Proc;
import com.risk.MangementAPI.operationalRisk.Model.Risk;
import com.risk.MangementAPI.operationalRisk.Model.RiskCategory;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class IncidentResponseDTO {
    private Long id;
    private LocalDate detectionDate;
    private LocalDate declarationDate;
    private LocalDate occurrenceDate;
    private int frequency ;
    private int impact ;
    private String Description ;
    private String riskCategory;
    private String process ;

    // You may need to add more fields here based on your requirements

    public IncidentResponseDTO toDto(Incident incident) {
        this.id = incident.getId();
        this.detectionDate = incident.getDetectionDate();
        this.declarationDate = incident.getDeclarationDate();
        this.occurrenceDate = incident.getOccuranceDate();
        this.frequency = incident.getFrequency();
        this.impact= incident.getImpact();
        this.Description=incident.getDescription();
        Risk risk = incident.getRisk() ;
        this.riskCategory =  risk.getRiskCategory().getName();

          this. process = risk.getProc().getProcName() ;

        // You may need to map more fields here based on your Incident entity
        return this;
    }
}
