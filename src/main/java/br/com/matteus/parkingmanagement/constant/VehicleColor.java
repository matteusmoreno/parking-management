package br.com.matteus.parkingmanagement.constant;

import lombok.Getter;

@Getter
public enum VehicleColor {

    BLACK("Preto"),
    WHITE("Branco"),
    SILVER("Prata"),
    GRAY("Cinza"),
    RED("Vermelho"),
    BLUE("Azul"),
    GREEN("Verde"),
    YELLOW("Amarelo"),
    BROWN("Marrom"),
    ORANGE("Laranja"),
    GOLD("Dourado"),
    PINK("Rosa"),
    PURPLE("Roxo"),
    BEIGE("Bege"),
    OTHER("Outra");


    private final String displayName;

    VehicleColor(String displayName) {
        this.displayName = displayName;
    }
}
