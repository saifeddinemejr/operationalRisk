package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddIncidentRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.IncidentResponseDTO;
import com.risk.MangementAPI.operationalRisk.Model.Incident;
import com.risk.MangementAPI.operationalRisk.Model.Proc;
import com.risk.MangementAPI.operationalRisk.Model.Risk;
import com.risk.MangementAPI.operationalRisk.Repositories.Incident_Repository;
import com.risk.MangementAPI.operationalRisk.Repositories.ProcRepository;
import com.risk.MangementAPI.operationalRisk.Repositories.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Incident_Service {

    private final Incident_Repository incidentRepository;
    private final RiskRepository riskRepository;
    private final ProcRepository procRepository;

    @Autowired
    public Incident_Service(Incident_Repository incidentRepository, RiskRepository riskRepository,ProcRepository procRepository) {
        this.incidentRepository = incidentRepository;
        this.riskRepository = riskRepository;
        this.procRepository = procRepository;
    }

    public void addIncident(AddIncidentRequestDTO data) {
        // Create an Incident entity
        Incident incident = new Incident();
        // Populate the Incident entity parameters with data from the request
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate detectionDate = LocalDate.parse(data.getDetectionDate(), formatter);
        LocalDate declarationDate = LocalDate.parse(data.getDeclarationDate(), formatter);
        LocalDate occurrenceDate = LocalDate.parse(data.getOccurrenceDate(), formatter);
        incident.setDetectionDate(detectionDate);
        incident.setDeclarationDate(declarationDate);
        incident.setOccuranceDate(occurrenceDate);
        incident.setFrequency(data.getFrequency());
        incident.setImpact(data.getImpact());
        incident.setDescription(data.getDescription());
        Risk risk = riskRepository.findById(data.getRiskId()).orElseThrow();
        incident.setRisk(risk);
//        System.out.println(risk);
        Proc proc = procRepository.findById(data.getProcId()).orElseThrow();
        incident.setProc(proc);
//        System.out.println(proc);
        // 1- you Must Add A Add 2 Varaibles One For The Risk id And One For The Proc Id

        //  in the ADD INCIDENT REQUEST DTO  name them risk_id and proc_id type int or long depends
        // o how you defined their ids in their @Entity class..
        // 2- Get The RISK AND Proc entityse FROM THE DATA BASE
        /* Your Code Might Look lIKE tHIS
        *  Risk risk = riskRepository.findById(risk_id).orElseThrow();
        * incident.setRisk(risk);
        * Risk proc = riskRepository.findById(proc_id).orElseThrow();
        * incident.setProc(proc);
        *
        */
        this.incidentRepository.save(incident);
    }

    public void updateIncident(Long incidentId, AddIncidentRequestDTO data) {
        Incident incident = new Incident();
        incident.setId(incidentId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate detectionDate = LocalDate.parse(data.getDetectionDate(), formatter);
        LocalDate declarationDate = LocalDate.parse(data.getDeclarationDate(), formatter);
        LocalDate occurrenceDate = LocalDate.parse(data.getOccurrenceDate(), formatter);
        incident.setDetectionDate(detectionDate);
        incident.setDeclarationDate(declarationDate);
        incident.setOccuranceDate(occurrenceDate);
        incident.setFrequency(data.getFrequency());
        incident.setImpact(data.getImpact());
        incident.setDescription(data.getDescription());
        Risk risk = riskRepository.findById(data.getRiskId()).orElseThrow();
        incident.setRisk(risk);
        Proc proc = procRepository.findById(data.getProcId()).orElseThrow();
        incident.setProc(proc);
        // You may need to set the Risk object for the incident as well, depending on your requirements
        // incident.setRisk(data.getRisk());
        // Save the updated entity in the database using the repository
        this.incidentRepository.save(incident);
    }

    public IncidentResponseDTO getIncidentById(Long incidentId) {
        Incident incident = incidentRepository.findById(incidentId).orElseThrow();
        return new IncidentResponseDTO().toDto(incident);
    }

    public List<IncidentResponseDTO> getAllIncidents() {
        List<Incident> incidents = this.incidentRepository.findAll();
        List<IncidentResponseDTO> response = new ArrayList<>();
        for (Incident incident : incidents) {
            response.add(new IncidentResponseDTO().toDto(incident));
        }
        return response;
    }

    public void deleteIncident(Long id) {
        Incident incident = this.incidentRepository.findById(id).orElseThrow();
        this.incidentRepository.delete(incident);
    }
}
