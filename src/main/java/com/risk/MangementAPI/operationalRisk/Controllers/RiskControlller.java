package com.risk.MangementAPI.operationalRisk.Controllers;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddRiskRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.MacroProcDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.ProcDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.RiskDTO;
import com.risk.MangementAPI.operationalRisk.Model.Macro_proc;
import com.risk.MangementAPI.operationalRisk.Model.Proc;
import com.risk.MangementAPI.operationalRisk.Services.MacroProcService;
import com.risk.MangementAPI.operationalRisk.Services.ProcService;
import com.risk.MangementAPI.operationalRisk.Services.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("riskmanagement/")
@CrossOrigin(origins="http://localhost:4200")

public class RiskControlller {
    private final MacroProcService macroProcService;
    private final RiskService riskService;
    private final ProcService procService ;
    @Autowired
    public RiskControlller(RiskService riskService , MacroProcService macroProcService , ProcService procServie){
        this.riskService = riskService;
        this.macroProcService = macroProcService;
        this.procService = procServie;

    }

    //
    @GetMapping("/get-macro-procByid/{id}")
    public MacroProcDTO getMacroProcById(@PathVariable Long id) {
        Macro_proc macroProc = macroProcService.getMacroProcById(id);
        return MacroProcDTO.fromEntity(macroProc); // Use the conversion method
    }
    @GetMapping("get-proc-by-id/{id}")
    public ProcDTO getProcById(@PathVariable Long id ){
        return procService.getProcById(id);

    }

    @GetMapping("/get-macro-proc/all")
    public List<MacroProcDTO> getAllMacroProcs() {
        return macroProcService.getAllMacroProcs().stream()
                .map(MacroProcDTO::fromEntity)
                .collect(Collectors.toList());
    }


    //
    @GetMapping("get-proc-by-macro/{id}")
    public List<ProcDTO> getProcByMacro(@PathVariable Long id ){
        return this.procService.getAllProcByMacro(id) ;
    }
    //

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
