package com.householdos.householdos.repository;

import com.householdos.householdos.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill,Long> {

}
