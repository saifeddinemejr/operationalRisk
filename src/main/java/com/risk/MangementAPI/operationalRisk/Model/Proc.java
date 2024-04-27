package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
public class Proc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Proc_Name")
    private String ProcName;

    // @OneToMany
    //  private Macro_proc macroProc ;
    @OneToMany(mappedBy = "proc")
    private List<Risk> risks ;
    @ManyToOne
    private Macro_proc macroProc;




}




