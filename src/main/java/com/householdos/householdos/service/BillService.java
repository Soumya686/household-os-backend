package com.householdos.householdos.service;

import com.householdos.householdos.entity.Bill;
import com.householdos.householdos.dto.CreateBillRequest;
import com.householdos.householdos.repository.BillRepository;
import com.householdos.householdos.exception.BillNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private final BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    public Bill createBill(CreateBillRequest request)
    {
       Bill bill = new Bill();
       bill.setName(request.getName().trim());
       bill.setType(request.getType());
       bill.setFrequency(request.getFrequency());
       bill.setDefaultAmount(request.getDefaultAmount());
       if (request.getActive() != null) {
           bill.setActive(request.getActive());
       }
       return billRepository.save(bill);
    }

    public Optional<Bill> getBillById(Long id)
    {
       return billRepository.findById(id);
    }

    public java.util.List<Bill> getBills() {
        return billRepository.findAll();
    }

    public Bill updateBill(Long id, CreateBillRequest request) {
       Bill bill = billRepository.findById(id).orElseThrow(() -> new BillNotFoundException(id));
       bill.setName(request.getName().trim());
       bill.setType(request.getType());
       bill.setFrequency(request.getFrequency());
       bill.setDefaultAmount(request.getDefaultAmount());
       if (request.getActive() != null) {
           bill.setActive(request.getActive());
       }
       return billRepository.save(bill);
    }


}
