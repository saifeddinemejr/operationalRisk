package com.risk.MangementAPI.operationalRisk.Services;

import com.risk.MangementAPI.operationalRisk.DTOs.Response.ProcDTO;
import com.risk.MangementAPI.operationalRisk.Model.Proc;
import com.risk.MangementAPI.operationalRisk.Repositories.ProcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcService {
    private ProcRepository procRepository ;
    @Autowired
    public ProcService(ProcRepository procRepository) {
        this.procRepository = procRepository;
    }
public List<ProcDTO> getAllProcByMacro(long macroProcId){
        List<Proc> Procs = this.procRepository.getProcByMaroProc(macroProcId) ;
        List<ProcDTO> result = new ArrayList<ProcDTO>() ;
        for (Proc p : Procs){
            result.add(ProcDTO.fromEntity(p) );
        }
    return result ;
 }

 public  ProcDTO getProcById(long procId){
        return  ProcDTO.fromEntity( this.procRepository.findById(procId).orElseThrow() )  ;
 }

}
