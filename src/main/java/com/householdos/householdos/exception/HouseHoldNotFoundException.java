package com.householdos.householdos.exception;

public class HouseHoldNotFoundException extends RuntimeException{

    public HouseHoldNotFoundException(Long id)
    {
        super("HouseHold Not found with id "+id);
    }
}
