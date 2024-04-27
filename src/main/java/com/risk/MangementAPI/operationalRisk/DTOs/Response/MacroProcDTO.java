package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Macro_proc;
import lombok.Data;

@Data
public class MacroProcDTO {
    private Long id;
    private String macroProcName;

    public static MacroProcDTO fromEntity(Macro_proc macroProc) {
        MacroProcDTO dto = new MacroProcDTO();
        dto.setId(macroProc.getId());
        dto.setMacroProcName(macroProc.getMacroProcName());
        return dto;
    }
    }

