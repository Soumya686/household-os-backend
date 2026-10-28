package com.householdos.householdos.entity;

import com.householdos.householdos.enums.BillFrequency;
import com.householdos.householdos.enums.BillType;
import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private BillType type;

    @Enumerated(EnumType.STRING)
    private BillFrequency frequency;

    private BigDecimal defaultAmount;

    private boolean active= true;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BillType getType() { return type; }

    public void setType(BillType type) { this.type = type; }

    public BigDecimal getDefaultAmount() { return defaultAmount; }

    public void setDefaultAmount(BigDecimal defaultAmount) { this.defaultAmount = defaultAmount; }

    public BillFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(BillFrequency frequency) {
        this.frequency = frequency;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Bill() {
    }
}
