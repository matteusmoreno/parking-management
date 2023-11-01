package br.com.matteus.parkingmanagement.exception;

public class NoParkingSpaceAvailableException extends RuntimeException{
    public NoParkingSpaceAvailableException(String message) {
        super("No parking space available");
    }
}
