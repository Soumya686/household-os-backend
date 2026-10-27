package com.householdos.householdos.exception;

public class MaintenanceAlreadyCompletedException extends RuntimeException{

    public MaintenanceAlreadyCompletedException(Long id){
        super("Maintenance already completed with id: " + id);
    }
}
