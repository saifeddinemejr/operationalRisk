package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy ="risk")
    private Set<Incident>  incidents ;
    @ManyToOne()
    private Proc proc ;
    @ManyToOne
    private RiskCategory riskCategory ;


}

