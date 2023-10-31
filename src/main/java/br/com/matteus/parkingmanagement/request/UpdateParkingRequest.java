package br.com.matteus.parkingmanagement.request;

import jakarta.validation.constraints.NotNull;

public record UpdateParkingRequest(
        @NotNull(message = "O id não pode ser nulo")
        Long id,
        String name,
        String cnpj,
        String cep,
        int motorcycleSpaces,
        int carSpaces) {
}
