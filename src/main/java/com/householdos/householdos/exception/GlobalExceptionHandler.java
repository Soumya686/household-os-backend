package com.householdos.householdos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MaintenanceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMaintenanceNotFound(
            MaintenanceNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(MaintenanceAlreadyCompletedException.class)
    public ResponseEntity<Map<String, String>> handleAlreadyCompleted(
            MaintenanceAlreadyCompletedException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("message", ex.getMessage()));
    }


    @ExceptionHandler(HouseHoldNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleHouseHoldNotFound(
            HouseHoldNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBillNotFound(
            HouseHoldNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {

        FieldError error = ex.getBindingResult()
                .getFieldErrors()
                .get(0);

        String message = error.getField() + ": " + error.getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", message));
    }
}