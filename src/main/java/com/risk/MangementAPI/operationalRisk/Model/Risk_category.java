package com.risk.MangementAPI.operationalRisk.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Risk_category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;




}
