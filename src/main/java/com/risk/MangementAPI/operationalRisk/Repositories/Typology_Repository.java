package com.risk.MangementAPI.operationalRisk.Repositories;

import com.risk.MangementAPI.operationalRisk.Model.Typology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Typology_Repository extends JpaRepository<Typology, Integer> {
    // Additional custom methods can be defined here if needed
}
