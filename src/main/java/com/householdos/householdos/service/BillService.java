package com.householdos.householdos.service;

import com.householdos.householdos.entity.Bill;
import com.householdos.householdos.enums.BillFrequency;
import com.householdos.householdos.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    public Bill createBill(String name, BillFrequency frequency)
    {
       Bill bill = new Bill();
       bill.setName(name);
       bill.setFrequency(frequency);
       return billRepository.save(bill);
    }

    public Optional<Bill> getBillById(Long id)
    {
       return billRepository.findById(id);
    }


}
