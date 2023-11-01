package br.com.matteus.parkingmanagement.dto;


public record Adress (
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
}
