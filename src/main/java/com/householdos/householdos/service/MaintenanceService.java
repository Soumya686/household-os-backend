package com.householdos.householdos.service;

import com.householdos.householdos.dto.CreateMaintenanceRequest;
import com.householdos.householdos.dto.SummaryResponse;
import com.householdos.householdos.entity.Maintenance;
import com.householdos.householdos.enums.MaintenanceStatus;
import com.householdos.householdos.exception.MaintenanceNotFoundException;
import com.householdos.householdos.repository.MaintenanceRepository;
import com.householdos.householdos.util.SummeryResponseMapping;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {


    private final MaintenanceRepository maintenanceRepository;

    private SummeryResponseMapping SummeryResponse;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Maintenance createMaintenance(CreateMaintenanceRequest createMaintenanceRequest )
    {
        Maintenance maintenance = new Maintenance();
        maintenance.setCreatedDate(LocalDateTime.now());
        maintenance.setTitle(createMaintenanceRequest.title());
        maintenance.setDueDate(createMaintenanceRequest.dueDate());
        maintenance.setStatus(MaintenanceStatus.PENDING);
        maintenance.setType(createMaintenanceRequest.type());
        maintenance.setDeleted(false);
        return maintenanceRepository.save(maintenance);
    }

    public List<Maintenance> getMaintenanceByNot() {
        return maintenanceRepository.findByDeletedFalse();
    }

    public Page<Maintenance> getMaintenanceByNot(Pageable page) {
        return maintenanceRepository.findByDeletedFalse(page);
    }

    public Optional<Maintenance> getMaintenanceById(Long id) {
        return maintenanceRepository.findByIdAndDeletedFalse(id);
    }

    public void deleteMaintenanceById(Long id){
       Maintenance maintenance = maintenanceRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new MaintenanceNotFoundException(id));
       maintenance.setDeleted(true);
       maintenanceRepository.save(maintenance);
    }

    public Maintenance updateMaintenance(Long id,CreateMaintenanceRequest createMaintenanceRequest )
    {
        Maintenance maintenance = maintenanceRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new MaintenanceNotFoundException(id));
        maintenance.setType(createMaintenanceRequest.type());
        maintenance.setTitle(createMaintenanceRequest.title());
        maintenance.setDueDate(createMaintenanceRequest.dueDate());
        return maintenanceRepository.save(maintenance);
    }

    @Transactional
    public Maintenance completeMaintenance(Long id) {
        Maintenance maintenance = maintenanceRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new MaintenanceNotFoundException(id));
        if(maintenance.getStatus()==MaintenanceStatus.COMPLETED)
        {
            throw new RuntimeException("Already completed");
        }
        maintenance.setStatus(MaintenanceStatus.COMPLETED);
        maintenance.setCompletedDate(LocalDate.now());
        return maintenanceRepository.save(maintenance);
    }

    public SummaryResponse getMaintenanceSummary()
    {
        Object[] result = maintenanceRepository.findMaintenanceSummary(
                MaintenanceStatus.PENDING,
                MaintenanceStatus.COMPLETED
        );
        return SummeryResponse.setSummeryfromResult(result);

        /*Object[] row = (Object[]) result[0];

        return new MaintenanceSummaryResponse(
                ((Number) row[0]).longValue(),
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue()
        );*/


    }
}
