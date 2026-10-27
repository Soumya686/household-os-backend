package com.householdos.householdos.service;

import com.householdos.householdos.dto.CreateBillOccurrenceRequest;
import com.householdos.householdos.entity.Bill;
import com.householdos.householdos.entity.BillOccurrence;
import com.householdos.householdos.enums.BillStatus;
import com.householdos.householdos.exception.BillNotFoundException;
import com.householdos.householdos.repository.BillOccurrenceRepository;
import com.householdos.householdos.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class BillOccurrenceService {

    final private BillOccurrenceRepository billOccurrenceRepository;

    final private BillRepository billRepository;

    public BillOccurrenceService(BillOccurrenceRepository billOccurrenceRepository, BillRepository billRepository) {
        this.billOccurrenceRepository = billOccurrenceRepository;
        this.billRepository = billRepository;
    }

    public BillOccurrence createBillOccurrence(CreateBillOccurrenceRequest request)
    {

        BillOccurrence billOccurrence = new BillOccurrence();
        Bill bill = billRepository.findById(request.getBillId()).orElseThrow(() -> new BillNotFoundException(request.getBillId()));
        billOccurrence.setAmount(request.getAmount());
        billOccurrence.setDueDate(request.getDueDate());
        billOccurrence.setStatus(BillStatus.PENDING);
        billOccurrence.setBill(bill);
        return billOccurrenceRepository.save(billOccurrence);
    }
}
