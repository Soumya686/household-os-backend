package com.householdos.householdos.dto;

public record SummaryResponse(

    long total,
    long pending,
    long completed,
    long overdue
) {
}

