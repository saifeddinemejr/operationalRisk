package com.risk.MangementAPI.operationalRisk.DTOs.Request;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AddRiskRequestDTO {
    private String typology ;
    private String category ;
    private int frequency ;
    private int impact ;
    private String description ;
    private Long procId ;

}
