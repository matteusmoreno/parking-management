package br.com.matteus.parkingmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "parking")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Parking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private int motorcycleSpaces;
    private int carSpaces;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean active;
}
