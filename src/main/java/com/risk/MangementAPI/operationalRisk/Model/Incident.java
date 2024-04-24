package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "detection_date" )
    private LocalDateTime  detectionDate ;
    @Column(name = "declaration_date" )
    private LocalDateTime  declarationDate ;
    @Column(name = "occurance_date" )
    private LocalDateTime  occuranceDate ;
    @ManyToOne
    private Risk risk ;
    @OneToOne
    private Macro_proc macroProc ;


}
