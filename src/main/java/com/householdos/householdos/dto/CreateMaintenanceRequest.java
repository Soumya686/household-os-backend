package com.householdos.householdos.dto;

import com.householdos.householdos.enums.MaintenanceType;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateMaintenanceRequest(
        @NotBlank String title,
        @NotNull MaintenanceType type,
        @FutureOrPresent
        @NotNull
        LocalDate dueDate
) {
}


