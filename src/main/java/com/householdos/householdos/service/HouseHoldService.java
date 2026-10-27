package com.householdos.householdos.service;


import com.householdos.householdos.entity.Household;
import com.householdos.householdos.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class HouseHoldService {

    private final HouseholdRepository householdRepository;

    public HouseHoldService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    public Household createHouseHold(String name) {
        Household household = new Household();
        household.setName(name);
        household.setCreatedAt(LocalDateTime.now());
        return householdRepository.save(household);
    }

    public Optional<Household>getHouseHold(Long id)
    {
        return householdRepository.findById(id);
    }
}
