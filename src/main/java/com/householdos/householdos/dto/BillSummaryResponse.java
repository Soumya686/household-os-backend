package com.householdos.householdos.dto;

public record BillSummaryResponse(
    long total,
    long pending,
    long paid,
    long overdue
) {
    }

