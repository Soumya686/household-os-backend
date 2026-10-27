package com.householdos.householdos.controller;

import com.householdos.householdos.entity.Household;
import com.householdos.householdos.exception.HouseHoldNotFoundException;
import com.householdos.householdos.service.HouseHoldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houseHold")
@CrossOrigin(origins = "http://localhost:3000")
public class HouseHoldController {

    private final HouseHoldService houseHoldService;


    public HouseHoldController(HouseHoldService houseHoldService) {
        this.houseHoldService = houseHoldService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Household createHouseHold(@RequestParam String name)
    {

        return houseHoldService.createHouseHold(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Household> getMaintenanceById(@PathVariable("id") Long id) {
        Household household = houseHoldService.getHouseHold(id)
                .orElseThrow(() -> new HouseHoldNotFoundException(id));
        return ResponseEntity.ok(household);
    }




}
