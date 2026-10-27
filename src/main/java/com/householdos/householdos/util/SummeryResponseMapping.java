package com.householdos.householdos.util;

import com.householdos.householdos.dto.SummaryResponse;

public class SummeryResponseMapping {

    public SummaryResponse setSummeryfromResult(Object result[])
    {
        Object[] row = (Object[]) result[0];

        return new SummaryResponse(
                ((Number) row[0]).longValue(),
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue()
        );

    }

}
