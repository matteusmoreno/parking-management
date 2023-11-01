package br.com.matteus.parkingmanagement.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.badRequest().body("Entity not found");
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(NoParkingSpaceAvailableException.class)
    public ResponseEntity handleNoParkingSpaceAvailableException(NoParkingSpaceAvailableException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(VehicleAlreadyParkedException.class)
    public ResponseEntity handleVehicleAlreadyParkedException(VehicleAlreadyParkedException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
