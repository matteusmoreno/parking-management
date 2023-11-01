package br.com.matteus.parkingmanagement.response;

import br.com.matteus.parkingmanagement.entity.Parking;

import java.time.LocalDateTime;

public record ParkingDetailsResponse(
        Long id,
        String name,
        String cnpj,
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        int motorcycleSpaces,
        int carSpaces,
        int parkedMotorcycles,
        int parkedCars,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deletedAt,
        Boolean active) {

    public ParkingDetailsResponse(Parking parking) {
        this(parking.getId(),
                parking.getName(),
                parking.getCnpj(),
                parking.getCep(),
                parking.getLogradouro(),
                parking.getBairro(),
                parking.getLocalidade(),
                parking.getUf(),
                parking.getMotorcycleSpaces(),
                parking.getCarSpaces(),
                parking.getParkedMotorcycles(),
                parking.getParkedCars(),
                parking.getCreatedAt(),
                parking.getUpdatedAt(),
                parking.getDeletedAt(),
                parking.getActive());
    }
}
