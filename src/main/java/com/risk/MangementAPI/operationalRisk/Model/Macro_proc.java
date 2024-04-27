package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Macro_proc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "Macro_Proc_Name" )
    private String MacroProcName ;
    @OneToMany(mappedBy = "macroProc")
    private List<Proc> processes  ;

}
