package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Risk;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RiskDTO {
    private int id ;
    private  String typology ;
    private String category ;
    private  String description ;
    private ProcDTO proc ;

    public  RiskDTO toDto(Risk risk ) {
        this.id=risk.getId() ;
//        this.typology=risk.getTypology() ;
//        this.category =risk.getCategory();
//        this.description=risk.getDescription() ;
        this.proc= ProcDTO.fromEntity(risk.getProc()) ;
        return this ;
    }

    
}
