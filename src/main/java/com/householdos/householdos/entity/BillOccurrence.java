package com.householdos.householdos.entity;

import com.householdos.householdos.enums.BillStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class BillOccurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    private LocalDate dueDate;

    private LocalDate paidDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private BillStatus status;

    public Bill getBill() {
        return bill;
    }

    public BillOccurrence() {
    }

    public BillOccurrence(Bill bill, LocalDate dueDate, LocalDate paidDate, BigDecimal amount, BillStatus status) {
        this.bill = bill;
        this.dueDate = dueDate;
        this.paidDate = paidDate;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate paidDate) {
        this.paidDate = paidDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }
}
