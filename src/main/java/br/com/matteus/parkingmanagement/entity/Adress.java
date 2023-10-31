package br.com.matteus.parkingmanagement.entity;


public record Adress (
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
}
