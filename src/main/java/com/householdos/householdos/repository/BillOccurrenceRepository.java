package com.householdos.householdos.repository;

import com.householdos.householdos.entity.BillOccurrence;
import com.householdos.householdos.enums.BillStatus;
import com.householdos.householdos.enums.MaintenanceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillOccurrenceRepository extends JpaRepository<BillOccurrence,Long> {

    @Override
    <S extends BillOccurrence> S save(S entity);

    Page<BillOccurrence> findAll(Pageable pageable);

    @Query("""
    SELECT
        COUNT(b),
        COALESCE(SUM(
            CASE WHEN b.status = :pendingStatus
                 THEN 1L ELSE 0L END
        ), 0L),
        COALESCE(SUM(
            CASE WHEN b.status = :paidStatus
                 THEN 1L ELSE 0L END
        ), 0L),
        COALESCE(SUM(
            CASE WHEN b.status = :pendingStatus
                      AND b.dueDate < CURRENT_DATE
                 THEN 1L ELSE 0L END
        ), 0L)
    FROM BillOccurrence b
    """)
    Object[] findBillOccurSummary(
            @Param("pendingStatus") BillStatus pendingStatus,
            @Param("paidStatus") BillStatus paidStatus
    );
}
