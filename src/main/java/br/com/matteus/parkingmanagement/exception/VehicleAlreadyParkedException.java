package br.com.matteus.parkingmanagement.exception;

public class VehicleAlreadyParkedException extends RuntimeException{
    public VehicleAlreadyParkedException(String message) {
        super("Vehicle already parked");
    }
}
