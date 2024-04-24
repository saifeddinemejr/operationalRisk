package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.*;
import lombok.*;


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
    @Column(name = "Proc_id" )
    private Long  ProcID ;

    //@OnetoMany
    //private Long Proc_id ProcID

}
