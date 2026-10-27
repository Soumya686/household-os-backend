package com.householdos.householdos.exception;

public class BillNotFoundException extends RuntimeException{

    public BillNotFoundException(Long id)
    {
        super("The bill not found with id "+id);
    }
}
