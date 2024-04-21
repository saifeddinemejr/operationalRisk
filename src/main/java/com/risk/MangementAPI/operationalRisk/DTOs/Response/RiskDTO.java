package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Risk;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RiskDTO {
    private int id ;
    private LocalDateTime date ;
    private  String typology ;
    private String category ;
    private int frequency ;
    private int impact ;
    private  String description ;

    // //
    // //
    //
    public  RiskDTO toDto(Risk risk ) {

        this.id=risk.getId() ;
        this.date=risk.getDate() ;
        this.typology=risk.getTypology() ;
        this.category =risk.getCategory();
        this.frequency = risk.getFrequency();
        this.impact= risk.getImpact(); ;
        this.description=risk.getDescription() ;
        return this ;
    }

    
}
