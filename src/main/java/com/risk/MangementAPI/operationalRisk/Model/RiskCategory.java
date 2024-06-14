package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RiskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Typology typology;
//    @ManyToOne
//    private RiskCategory riskCategory;
//    @OneToMany(mappedBy = "riskCategory")
//    private List<Risk> risks;
//    @OneToMany(mappedBy = "riskCategory")
//    private List<Proc> procs;
}
