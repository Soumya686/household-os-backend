package com.householdos.householdos.controller;

import com.householdos.householdos.dto.BillSummaryResponse;
import com.householdos.householdos.dto.CreateBillOccurrenceRequest;
import com.householdos.householdos.dto.SummaryResponse;
import com.householdos.householdos.entity.BillOccurrence;
import com.householdos.householdos.entity.Maintenance;
import com.householdos.householdos.service.BillOccurrenceService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill-occurrences")
@CrossOrigin(origins = "http://localhost:3000")
public class BillOccurrenceController {

    private final BillOccurrenceService billOccurrenceService;

    public BillOccurrenceController(BillOccurrenceService billOccurrenceService) {
        this.billOccurrenceService = billOccurrenceService;
    }

    @GetMapping("/pagination")
    public Page<BillOccurrence> getAllBillOccurances(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("dueDate").ascending());
        return billOccurrenceService.getBillOccurrence(pageable);
    }



    @PostMapping
    public BillOccurrence createBillOccurence(@Valid @RequestBody CreateBillOccurrenceRequest request)
    {
        return billOccurrenceService.createBillOccurrence(request);
    }

    @PutMapping("/{billOccId}/pay")
    public BillOccurrence updateBillOccurrence(@PathVariable Long billOccId) {
        return billOccurrenceService.updateBillOccurrence(billOccId);
    }

    @GetMapping("/summary")
    public BillSummaryResponse getBillOccurrenceSummary() {
        return billOccurrenceService.getBillOccSummary();
    }


}
