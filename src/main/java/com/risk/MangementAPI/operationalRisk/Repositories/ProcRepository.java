package com.risk.MangementAPI.operationalRisk.Repositories;

import com.risk.MangementAPI.operationalRisk.Model.Proc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProcRepository extends  JpaRepository<Proc,Long> {
    @Query(value = " SELECT * FROM Proc WHERE macro_proc_id=?"
            , nativeQuery = true)
    List<Proc> getProcByMaroProc( Long macroProcId); ;

}
