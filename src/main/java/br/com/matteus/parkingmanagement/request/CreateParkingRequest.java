package br.com.matteus.parkingmanagement.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateParkingRequest(
        @NotBlank(message = "O nome do estacionamento não pode ser vazio")
        String name,
        @NotBlank(message = "O CNPJ não pode ser vazio")
        @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "O CNPJ deve estar no formato 00.000.000/0000-00")
        String cnpj,
        @NotBlank(message = "O CEP não pode ser vazio")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000")
        String cep,
        int motorcycleSpaces,
        int carSpaces) {
}
