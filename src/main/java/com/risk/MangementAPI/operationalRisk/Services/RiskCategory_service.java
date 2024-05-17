package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.Model.RiskCategory;
import com.risk.MangementAPI.operationalRisk.Repositories.RiskCategory_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiskCategory_service {

    private final RiskCategory_Repository riskCategory_Repository;

    @Autowired
    public RiskCategory_service(RiskCategory_Repository riskCategory_Repository) {
        this.riskCategory_Repository = riskCategory_Repository;
    }
    public RiskCategory findById(Long id) {
        Optional<RiskCategory> riskCategoryOptional = riskCategory_Repository.findById(id);
        return riskCategoryOptional.orElse(null);
    }

    public List<RiskCategory> findAll() {
        return riskCategory_Repository.findAll();
    }
       // Add any additional methods as needed
}
