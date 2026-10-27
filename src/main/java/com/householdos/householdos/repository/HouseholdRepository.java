package com.householdos.householdos.repository;
import com.householdos.householdos.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household,Long> {

    @Override
    <S extends Household> S save(S entity);

    Optional<Household> findById(Long id);

}
