package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddRiskRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.RiskDTO;
import com.risk.MangementAPI.operationalRisk.Model.Risk;
import com.risk.MangementAPI.operationalRisk.Repositories.RiskRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    // MRO : ADD ,  DELETE  , UPDATE ,  ADD : Risk ,Processus , MacroProc
    private final RiskRepository riskRepository ;
    @Autowired
    public  AdminService(RiskRepository riskRepository ){
        this.riskRepository = riskRepository ;
    }

    public  void addRisk(AddRiskRequestDTO data ) {
        // Create A Risk Entity
        Risk risk = new Risk();
        // Populate The Risk Entity parametters with data that we will get from the request ...
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(data.getDate() , formatter);
        risk.setDate(date ) ;
        risk.setDescription(data.getDescription());
        risk.setFrequency(data.getFrequency());
        risk.setTypology(data.getTypology());
        risk.setImpact(data.getImpact());
        risk.setCategory(data.getCategory());
        // Save The New Entity In The Data Base Using the Repo
        this.riskRepository.save(risk) ;
    }


    public void updateRisk (int  riskId ,  AddRiskRequestDTO data ){
        Risk risk = new Risk();
        risk.setId( riskId );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(data.getDate() , formatter);
        risk.setDate(date ) ;
        risk.setDescription(data.getDescription());
        risk.setFrequency(data.getFrequency());
        risk.setTypology(data.getTypology());
        risk.setImpact(data.getImpact());
        risk.setCategory(data.getCategory());
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
