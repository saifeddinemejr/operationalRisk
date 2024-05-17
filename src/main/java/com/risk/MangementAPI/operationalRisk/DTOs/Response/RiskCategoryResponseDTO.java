package com.risk.MangementAPI.operationalRisk.DTOs.Response;

import com.risk.MangementAPI.operationalRisk.Model.RiskCategory;
import lombok.Data;

@Data
public class RiskCategoryResponseDTO {

    private Long id;
    private String name;

    // Constructors
    public RiskCategoryResponseDTO() {}

    public RiskCategoryResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Mapping method (example)
    public static RiskCategoryResponseDTO mapFromEntity(RiskCategory entity) {
        if (entity == null) {
            return null;
        }
        return new RiskCategoryResponseDTO(entity.getId(), entity.getName());
    }
}
