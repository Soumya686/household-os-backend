package com.householdos.householdos.controller;

import com.householdos.householdos.entity.Bill;
import com.householdos.householdos.enums.BillFrequency;
import com.householdos.householdos.exception.BillNotFoundException;
import com.householdos.householdos.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/bill")
public class BillController {

   private final BillService billService;


    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bill createBill(@RequestParam String name, @RequestParam BillFrequency frequency)
    {
        return billService.createBill(name,frequency);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id) {
        Bill bill = billService.getBillById(id)
                .orElseThrow(() -> new BillNotFoundException(id));
        return ResponseEntity.ok(bill);
    }

}
