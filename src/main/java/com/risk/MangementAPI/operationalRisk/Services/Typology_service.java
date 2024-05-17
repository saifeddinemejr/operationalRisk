package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.Repositories.Typology_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Typology_service {

    private final Typology_Repository typology_repository;

    @Autowired
    public Typology_service(Typology_Repository typology_Repository) {
        this.typology_repository = typology_Repository;
    }

    // Add any additional methods as needed
}
