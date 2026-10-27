package com.householdos.householdos.entity;

import com.householdos.householdos.enums.BillFrequency;
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
    private BillFrequency frequency;

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
