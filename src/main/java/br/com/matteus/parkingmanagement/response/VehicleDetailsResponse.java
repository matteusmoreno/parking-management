package br.com.matteus.parkingmanagement.response;

import br.com.matteus.parkingmanagement.entity.Vehicle;

import java.time.LocalDateTime;

public record VehicleDetailsResponse(
        Long id,
        String brand,
        String model,
        String color,
        String plate,
        String type,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt,
        Boolean active) {

    public VehicleDetailsResponse(Vehicle vehicle) {
        this(vehicle.getId(),
                vehicle.getBrand().getDisplayName(),
                vehicle.getModel().getDisplayName(),
                vehicle.getColor().getDisplayName(),
                vehicle.getPlate(),
                vehicle.getType().getDisplayName(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt(),
                vehicle.getDeletedAt(),
                vehicle.getActive());
    }
}
