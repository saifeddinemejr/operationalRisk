package com.risk.MangementAPI.operationalRisk.DTOs.Request;

import lombok.Data;

@Data
public class AddMacroProcRequestDTO {
    private String macroProcName;
    private Long procID;

    // Add constructors, getters, and setters as needed
}
