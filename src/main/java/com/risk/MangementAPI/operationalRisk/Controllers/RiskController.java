package com.risk.MangementAPI.operationalRisk.Controllers;


import com.risk.MangementAPI.operationalRisk.DTOs.Response.MacroProcDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.ProcDTO;
import com.risk.MangementAPI.operationalRisk.Model.Macro_proc;
import com.risk.MangementAPI.operationalRisk.Model.RiskCategory;
import com.risk.MangementAPI.operationalRisk.Services.MacroProcService;
import com.risk.MangementAPI.operationalRisk.Services.ProcService;
import com.risk.MangementAPI.operationalRisk.Services.RiskCategory_service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("riskmanagement/")
@CrossOrigin(origins="http://localhost:4200")
@RequiredArgsConstructor
public class RiskController {
    private final MacroProcService macroProcService;
    private final ProcService procService ;
    private final RiskCategory_service rcService;


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


    @GetMapping("get-proc-by-macro/{id}")
    public List<ProcDTO> getProcByMacro(@PathVariable Long id ){
        return this.procService.getAllProcByMacro(id) ;
    }

    @GetMapping("get-riskcategoryById/{id}")
    public RiskCategory getRiskCategoryById(@PathVariable Long id) {
      return  rcService.findById(id);
    }

    @GetMapping("get-all-riskcategory/all")
    public List<RiskCategory> getAllRiskCategories() {
        List<RiskCategory> riskCategories = rcService.findAll();
        return riskCategories;
    }
}
