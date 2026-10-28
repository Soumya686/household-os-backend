package com.householdos.householdos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateBillOccurrenceRequest {

    @NotNull
    private Long billId;

    @DecimalMin(value = "0.00", inclusive = false)
    private BigDecimal amount;

    @NotNull
    private LocalDate dueDate;

    public Long getBillId() {
        return billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
