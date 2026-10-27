package com.householdos.householdos.exception;

public class MaintenanceNotFoundException extends RuntimeException{

    public MaintenanceNotFoundException(Long id) {
        super("Maintenance not found with id: " + id);
    }
}
