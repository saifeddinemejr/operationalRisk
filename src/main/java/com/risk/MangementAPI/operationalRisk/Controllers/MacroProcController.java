package com.risk.MangementAPI.operationalRisk.Controllers;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddMacroProcRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.MacroProcDTO;
import com.risk.MangementAPI.operationalRisk.Model.Macro_proc;
import com.risk.MangementAPI.operationalRisk.Services.MacroProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("riskmanagement/")
public class MacroProcController {

    private final MacroProcService macroProcService;

    @Autowired
    public MacroProcController(MacroProcService macroProcService) {
        this.macroProcService = macroProcService;
    }

    @PostMapping("/add-macro-proc")
    public void addMacroProc(@RequestBody AddMacroProcRequestDTO data) {
        macroProcService.addMacroProc(data);
    }

    @PutMapping("/update-macro-proc/{id}")
    public void updateMacroProc(@PathVariable Long id, @RequestBody AddMacroProcRequestDTO data) {
        macroProcService.updateMacroProc(id, data);
    }


    @GetMapping("/get-macro-procByid/{id}")
    public MacroProcDTO getMacroProcById(@PathVariable Long id) {
        Macro_proc macroProc = macroProcService.getMacroProcById(id);
        return MacroProcDTO.fromEntity(macroProc); // Use the conversion method
    }

    @GetMapping("/get-macro-proc/all")
    public List<MacroProcDTO> getAllMacroProcs() {
        return macroProcService.getAllMacroProcs().stream()
                .map(MacroProcDTO::fromEntity)
                .collect(Collectors.toList());
    }
// i should add a Delete feature
}
