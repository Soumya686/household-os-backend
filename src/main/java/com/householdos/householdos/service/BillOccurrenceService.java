package com.householdos.householdos.service;

import com.householdos.householdos.dto.BillSummaryResponse;
import com.householdos.householdos.dto.CreateBillOccurrenceRequest;
import com.householdos.householdos.dto.SummaryResponse;
import com.householdos.householdos.entity.Bill;
import com.householdos.householdos.entity.BillOccurrence;
import com.householdos.householdos.enums.BillStatus;
import com.householdos.householdos.exception.BillNotFoundException;
import com.householdos.householdos.repository.BillOccurrenceRepository;
import com.householdos.householdos.repository.BillRepository;
import com.householdos.householdos.util.SummeryResponseMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillOccurrenceService {

    final private BillOccurrenceRepository billOccurrenceRepository;

    final private BillRepository billRepository;

    SummeryResponseMapping summeryResponse;

    public BillOccurrenceService(BillOccurrenceRepository billOccurrenceRepository, BillRepository billRepository) {
        this.billOccurrenceRepository = billOccurrenceRepository;
        this.billRepository = billRepository;
    }

    public Page<BillOccurrence> getBillOccurrence(Pageable pageable) {
        return billOccurrenceRepository.findAll(pageable);
    }

    public BillOccurrence createBillOccurrence(CreateBillOccurrenceRequest request) {

        BillOccurrence billOccurrence = new BillOccurrence();
        Bill bill = billRepository.findById(request.getBillId()).orElseThrow(() -> new BillNotFoundException(request.getBillId()));
        billOccurrence.setAmount(request.getAmount());
        billOccurrence.setDueDate(request.getDueDate());
        billOccurrence.setStatus(BillStatus.PENDING);
        billOccurrence.setBill(bill);
        return billOccurrenceRepository.save(billOccurrence);
    }

    public BillOccurrence updateBillOccurrence(Long billOccId) {
        BillOccurrence billOccurrence = billOccurrenceRepository
                .findById(billOccId)
                .orElseThrow(() -> new BillNotFoundException(billOccId));
        if (billOccurrence.getStatus() != BillStatus.PAID) {
            billOccurrence.setStatus(BillStatus.PAID);
            billOccurrence.setPaidDate(LocalDate.now());
        }
        return billOccurrenceRepository.save(billOccurrence);
    }

    public BillSummaryResponse getBillOccSummary() {
        Object[] result = billOccurrenceRepository.findBillOccurSummary(
                BillStatus.PENDING,
                BillStatus.PAID
        );
        Object[] row = (Object[]) result[0];

        return new BillSummaryResponse(
                ((Number) row[0]).longValue(),
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue()
        );
    }
}
