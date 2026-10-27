package com.householdos.householdos.dto;

public record MaintenanceSummaryResponse(

    long total,
    long pending,
    long completed,
    long overdue
) {
}

