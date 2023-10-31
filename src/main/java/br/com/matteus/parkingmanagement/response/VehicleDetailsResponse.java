package br.com.matteus.parkingmanagement.response;

import br.com.matteus.parkingmanagement.entity.Vehicle;

public record VehicleDetailsResponse(
        Long id,
        String brand,
        String model,
        String color,
        String plate,
        String type) {

    public VehicleDetailsResponse(Vehicle vehicle) {
        this(vehicle.getId(),
                vehicle.getBrand().getDisplayName(),
                vehicle.getModel().getDisplayName(),
                vehicle.getColor().getDisplayName(),
                vehicle.getPlate(),
                vehicle.getType().getDisplayName());
    }
}
