package com.householdos.householdos.controller;

import com.householdos.householdos.dto.CreateBillOccurrenceRequest;
import com.householdos.householdos.entity.BillOccurrence;
import com.householdos.householdos.service.BillOccurrenceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/bill-occurrences")
public class BillOccurrenceController {

    private final BillOccurrenceService billOccurrenceService;

    public BillOccurrenceController(BillOccurrenceService billOccurrenceService) {
        this.billOccurrenceService = billOccurrenceService;
    }


    @PostMapping
    public BillOccurrence createBillOccurence(@Valid @RequestBody CreateBillOccurrenceRequest request)
    {
        return billOccurrenceService.createBillOccurrence(request);
    }
}
