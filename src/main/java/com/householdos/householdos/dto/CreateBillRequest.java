package com.householdos.householdos.dto;

import com.householdos.householdos.enums.BillFrequency;
import com.householdos.householdos.enums.BillType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import jakarta.validation.constraints.Size;

public class CreateBillRequest {
    @NotBlank
    @Size(max = 120)
    private String name;

    @NotNull
    private BillType type;

    @NotNull
    private BillFrequency frequency;

    @DecimalMin(value = "0.00", inclusive = false)
    private BigDecimal defaultAmount;

    private Boolean active;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BillType getType() { return type; }
    public void setType(BillType type) { this.type = type; }
    public BillFrequency getFrequency() { return frequency; }
    public void setFrequency(BillFrequency frequency) { this.frequency = frequency; }
    public BigDecimal getDefaultAmount() { return defaultAmount; }
    public void setDefaultAmount(BigDecimal defaultAmount) { this.defaultAmount = defaultAmount; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
