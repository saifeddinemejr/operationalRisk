package com.risk.MangementAPI.operationalRisk.Controllers;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddRiskRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.RiskDTO;
import com.risk.MangementAPI.operationalRisk.Services.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("riskmanagement/")

public class RiskControlller {

    private final RiskService riskService;
    @Autowired
    public RiskControlller(RiskService riskService){
        this.riskService = riskService;
    }

    @PostMapping("add-risk")
    public void addRisk(@RequestBody  AddRiskRequestDTO data ){
        riskService.addRisk(data);
    }


    @PutMapping("update-risk/{id}")
    public void updateRisk(@PathVariable int id , @RequestBody AddRiskRequestDTO data  ){
        this.riskService.updateRisk(id,data );
    }

    @GetMapping("get-risk-by-id/{id}")
    public RiskDTO getRiskById(@PathVariable int id ){
        return this.riskService.getRiskById(id);
    }

    @GetMapping("get-all-risks")
    public List<RiskDTO> getAllRisks(){
        return this.riskService.getAllRisks() ;
    }

    @DeleteMapping("delete-risk/{id}")
    public void deleteRisk(@PathVariable int id ){
        this.riskService.deleteRisk(id);
    }

}
