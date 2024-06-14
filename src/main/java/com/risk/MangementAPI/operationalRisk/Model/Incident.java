package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "detection_date" )
    private LocalDate detectionDate ;
    @Column(name = "declaration_date" )
    private LocalDate  declarationDate ;
    @Column(name = "occurance_date" )
    private LocalDate  occuranceDate ;
    @Column(name = "frequency")
    private int frequency ;
    @Column(name= "impact")
    private int impact ;
    @Column(name="description")
    private String description ;
//    @ManyToOne
//    private Risk risk ;
    @ManyToOne
    RiskCategory riskCategory ;
    @ManyToOne
    Proc proc ;
    //
    //
    //
    //


}
