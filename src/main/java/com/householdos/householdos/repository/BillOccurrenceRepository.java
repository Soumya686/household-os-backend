package com.householdos.householdos.repository;

import com.householdos.householdos.entity.BillOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillOccurrenceRepository extends JpaRepository<BillOccurrence,Long> {

    @Override
    <S extends BillOccurrence> S save(S entity);
}
