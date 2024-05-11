package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddRiskRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.RiskDTO;
import com.risk.MangementAPI.operationalRisk.Model.Proc;
import com.risk.MangementAPI.operationalRisk.Model.Risk;
import com.risk.MangementAPI.operationalRisk.Repositories.ProcRepository;
import com.risk.MangementAPI.operationalRisk.Repositories.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class RiskService {
    // MRO : ADD ,  DELETE  , UPDATE ,  Get : Risk ,Processus , MacroProc
    private final RiskRepository riskRepository ;
    private final ProcRepository procRepository ;
    @Autowired
    public RiskService(RiskRepository riskRepository , ProcRepository procRepository  ){
        this.riskRepository = riskRepository ;
        this.procRepository = procRepository ;
    }

    public  void addRisk(AddRiskRequestDTO data ) {
        // Create A Risk Entity
        Risk risk = new Risk();
        risk.setDescription(data.getDescription());
//        risk.setTypology(data.getTypology());
//        risk.setCategory(data.getCategory());
        Proc proc = this.procRepository.findById(data.getProcId()).orElseThrow();
        risk.setProc(proc);
        // Save The New Entity In The Data Base Using the Repo
        this.riskRepository.save(risk) ;
    }


    public void updateRisk (int  riskId ,  AddRiskRequestDTO data ){
        Risk risk = new Risk();
        risk.setId( riskId );
        risk.setDescription(data.getDescription());
//        risk.setTypology(data.getTypology());
//        risk.setCategory(data.getCategory());
        Proc proc = this.procRepository.findById(data.getProcId()).orElseThrow();
        risk.setProc(proc);
        // Save The New Entity In The Data Base Using the Repo
        this.riskRepository.save(risk) ;

    }

    public RiskDTO getRiskById(int riskId ){
        Risk risk = riskRepository.findById(riskId).orElseThrow() ;
        return  new RiskDTO().toDto(risk) ;
    }

    public List<RiskDTO> getAllRisks() {
        List<Risk> risks = this.riskRepository.findAll();
        List<RiskDTO> response = new ArrayList<>() ;
        for (Risk risk :risks ){
            response.add(new RiskDTO().toDto(risk) ) ;
        }
        return  response ;

    }

    public void  deleteRisk(int id ){
        Risk risk = this.riskRepository.findById(id).orElseThrow();
        this.riskRepository.delete(risk); ;
    }
    // Delete Risk


}
