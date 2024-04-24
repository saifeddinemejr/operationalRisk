package com.risk.MangementAPI.operationalRisk.Repositories;

import com.risk.MangementAPI.operationalRisk.Model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Incident_Repository extends JpaRepository<Incident, Long> {
}
