package com.householdos.householdos.controller;

import com.householdos.householdos.entity.Bill;
import com.householdos.householdos.dto.CreateBillRequest;
import jakarta.validation.Valid;
import com.householdos.householdos.exception.BillNotFoundException;
import com.householdos.householdos.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bill")
public class BillController {

   private final BillService billService;


    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bill createBill(@Valid @RequestBody CreateBillRequest request)
    {
        return billService.createBill(request);
    }

    @GetMapping
    public java.util.List<Bill> getBills() {
        return billService.getBills();
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable("id") Long id, @Valid @RequestBody CreateBillRequest request) {
        return billService.updateBill(id, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id) {
        Bill bill = billService.getBillById(id)
                .orElseThrow(() -> new BillNotFoundException(id));
        return ResponseEntity.ok(bill);
    }

}
