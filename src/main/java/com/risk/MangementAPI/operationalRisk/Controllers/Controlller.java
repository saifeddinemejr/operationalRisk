package com.risk.MangementAPI.operationalRisk.Controllers;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddRiskRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.RiskDTO;
import com.risk.MangementAPI.operationalRisk.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("riskmanagement/")

public class Controlller {

    private final AdminService adminService ;
    @Autowired
    public  Controlller (AdminService adminService ){
        this.adminService=adminService ;
    }

    @PostMapping("add-risk")
    public void addRisk(@RequestBody  AddRiskRequestDTO data ){
        adminService.addRisk(data);
    }


    @PutMapping("update-risk/{id}")
    public void updateRisk(@PathVariable int id , @RequestBody AddRiskRequestDTO data  ){
        this.adminService.updateRisk(id,data );
    }

    @GetMapping("get-risk-by-id/{id}")
    public RiskDTO getRiskById(@PathVariable int id ){
        return this.adminService.getRiskById(id);
    }

    @GetMapping("get-all-risks")
    public List<RiskDTO> getAllRisks(){
        return this.adminService.getAllRisks() ;
    }
    @DeleteMapping("delete-risk/{id}")
    public void deleteRisk(@PathVariable int id ){
        this.adminService.deleteRisk(id);
    }

}
