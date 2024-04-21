package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

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

    private LocalDateTime date ;
    private  String typology ;
    private String category ;
    private int frequency ;
    private int impact ;

    @Column(columnDefinition = "text")
    private  String description ;

}
