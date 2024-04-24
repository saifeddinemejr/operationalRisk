package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.DTOs.Request.AddMacroProcRequestDTO;
import com.risk.MangementAPI.operationalRisk.Model.Macro_proc;
import com.risk.MangementAPI.operationalRisk.Repositories.Macro_Proc_Repository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MacroProcService {

    private final Macro_Proc_Repository macroProcRepository;

    @Autowired
    public MacroProcService(Macro_Proc_Repository macroProcRepository) {
        this.macroProcRepository = macroProcRepository;
    }

    public void addMacroProc(AddMacroProcRequestDTO data) {
        Macro_proc macroProc = new Macro_proc();
        macroProc.setMacroProcName(data.getMacroProcName());
        macroProc.setProcID(data.getProcID());
        this.macroProcRepository.save(macroProc);
    }

    public void updateMacroProc(Long id, AddMacroProcRequestDTO data) {
        Macro_proc macroProc = macroProcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Macro_proc not found with id: " + id));
        macroProc.setMacroProcName(data.getMacroProcName());
        macroProc.setProcID(data.getProcID());
        this.macroProcRepository.save(macroProc);
    }

    public Macro_proc getMacroProcById(Long id) {
        return macroProcRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Macro_proc not found with id: " + id));
    }

    public List<Macro_proc> getAllMacroProcs() {
        return macroProcRepository.findAll();
    }
}
