package com.householdos.householdos.repository;

import com.householdos.householdos.entity.Maintenance;
import com.householdos.householdos.enums.MaintenanceStatus;
import com.householdos.householdos.enums.MaintenanceType;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MaintenanceRepository extends JpaRepository <Maintenance,Long>{

    @Override
    <S extends Maintenance> S save(S entity);

    List<Maintenance> findByDeletedFalse();

    Page<Maintenance> findByDeletedFalse(Pageable pageable);

    Optional<Maintenance> findByIdAndDeletedFalse(Long id);

    List<Maintenance> findByDeletedFalseAndStatus(MaintenanceStatus status);

    @Query("""
    SELECT
        COUNT(m),
        COALESCE(SUM(
            CASE WHEN m.status = :pendingStatus
                 THEN 1L ELSE 0L END
        ), 0L),
        COALESCE(SUM(
            CASE WHEN m.status = :completedStatus
                 THEN 1L ELSE 0L END
        ), 0L),
        COALESCE(SUM(
            CASE WHEN m.status = :pendingStatus
                      AND m.dueDate < CURRENT_DATE
                 THEN 1L ELSE 0L END
        ), 0L)
    FROM Maintenance m
    WHERE m.deleted = false
    """)
    Object[] findMaintenanceSummary(
            @Param("pendingStatus") MaintenanceStatus pendingStatus,
            @Param("completedStatus") MaintenanceStatus completedStatus
    );

}
;