package com.risk.MangementAPI.operationalRisk.Repositories;

import com.risk.MangementAPI.operationalRisk.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface User_Repository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
