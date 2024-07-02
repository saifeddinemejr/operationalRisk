package com.risk.MangementAPI.operationalRisk.Controllers;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddIncidentRequestDTO;
import com.risk.MangementAPI.operationalRisk.DTOs.Response.IncidentResponseDTO;
import com.risk.MangementAPI.operationalRisk.Services.Incident_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("riskmanagement/")
@CrossOrigin(origins="http://localhost:4200")
public class IncidentController {

    private final Incident_Service incidentService;

    @Autowired
    public IncidentController(Incident_Service incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping("add-incident")
    public void addIncident(@RequestBody AddIncidentRequestDTO data) {
        System.out.println(data);
        incidentService.addIncident(data);
    }

    @PutMapping("update-incident/{id}")
    public void updateIncident(@PathVariable Long id, @RequestBody AddIncidentRequestDTO data) {
        incidentService.updateIncident(id, data);
    }

    @GetMapping("get-incident-by-id/{id}")
    public IncidentResponseDTO getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id);
    }

    @GetMapping("get-all-incidents")
    public List<IncidentResponseDTO> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @DeleteMapping("delete-incident/{id}")
    public void deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
    }
}
