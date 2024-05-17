package com.risk.MangementAPI.operationalRisk.Repositories;

import com.risk.MangementAPI.operationalRisk.Model.RiskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskCategory_Repository extends JpaRepository<RiskCategory, Long> {
}
