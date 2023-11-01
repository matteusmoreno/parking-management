package br.com.matteus.parkingmanagement.request;

import jakarta.validation.constraints.NotNull;

public record ParkingVehicleRequest(
        @NotNull(message = "O id do veículo não pode ser nulo")
        Long vehicleId,
        @NotNull(message = "O id do estacionamento não pode ser nulo")
        Long parkingId) {
}
