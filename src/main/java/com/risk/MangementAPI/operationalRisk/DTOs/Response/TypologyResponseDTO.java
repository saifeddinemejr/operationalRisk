package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.Typology;
import lombok.Data;

import java.util.Set;

@Data
public class TypologyResponseDTO {
    private int id;
    private String name;
    private Set<RiskCategoryResponseDTO> categories;

    // Add constructors and mapping methods as needed
}
