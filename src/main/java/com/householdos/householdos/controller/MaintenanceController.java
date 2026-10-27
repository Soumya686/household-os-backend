package com.householdos.householdos.controller;

import com.householdos.householdos.dto.CreateMaintenanceRequest;
import com.householdos.householdos.dto.MaintenanceSummaryResponse;
import com.householdos.householdos.entity.Maintenance;
import com.householdos.householdos.service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import com.householdos.householdos.exception.MaintenanceNotFoundException;




@RestController
@RequestMapping("/maintenance")
@CrossOrigin(origins = "http://localhost:3000")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Maintenance createMaintenance(@Valid @RequestBody CreateMaintenanceRequest request) {
        return maintenanceService.createMaintenance(request);
    }

    @GetMapping
    public List<Maintenance> getAllMaintenance() {

        return maintenanceService.getMaintenanceByNot();
    }

    @GetMapping("/pagination")
    public Page<Maintenance> getAllMaintenance(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("dueDate").ascending());
        return maintenanceService.getMaintenanceByNot(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable("id") Long id) {
        Maintenance maintenance = maintenanceService.getMaintenanceById(id)
                .orElseThrow(() -> new MaintenanceNotFoundException(id));
        return ResponseEntity.ok(maintenance);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMaintenanceById(@PathVariable("id") Long id) {
          maintenanceService.deleteMaintenanceById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable Long id,@Valid @RequestBody CreateMaintenanceRequest request) {
        return maintenanceService.updateMaintenance(id,request);
    }

    @PatchMapping("/{id}/complete")
    public Maintenance completeMaintenance(@PathVariable Long id) {
        return maintenanceService.completeMaintenance(id);
    }

    @GetMapping("/summary")
    public  MaintenanceSummaryResponse MaintenanceSummery()
    {
       return maintenanceService.getMaintenanceSummary();
    }

}
