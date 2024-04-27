package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Macro_proc;
import com.risk.MangementAPI.operationalRisk.Model.Proc;
import com.risk.MangementAPI.operationalRisk.Model.Risk;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ProcDTO {
    private Long id;
    private String ProcName;

    public static ProcDTO fromEntity(Proc proc ) {
        ProcDTO dto  = new ProcDTO() ;
        dto.setId(proc.getId());
        dto.setProcName(proc.getProcName());
        return dto;
    }
}
