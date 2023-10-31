package br.com.matteus.parkingmanagement.constant;

import lombok.Getter;

@Getter
public enum VehicleBrand {
    AUDI("Audi"),
    BMW("BMW"),
    CHEVROLET("Chevrolet"),
    CITROEN("Citroen"),
    FIAT("Fiat"),
    FORD("Ford"),
    YAMAHA("Yamaha"),
    HONDA("Honda"),
    HYUNDAI("Hyundai"),
    JEEP("Jeep"),
    KIA("Kia"),
    MERCEDES("Mercedes"),
    MITSUBISHI("Mitsubishi"),
    NISSAN("Nissan"),
    PEUGEOT("Peugeot"),
    RENAULT("Renault"),
    TOYOTA("Toyota"),
    VOLKSWAGEN("Volkswagen"),
    VOLVO("Volvo"),
    DAFRA("Dafra"),
    DUCATI("Ducati"),
    HARLEY("Harley-Davidson"),
    KAWASAKI("Kawasaki"),
    SUZUKI("Suzuki"),
    TRIUMPH("Triumph"),
    OTHER("Outra");

    private final String displayName;

    VehicleBrand(String displayName) {
        this.displayName = displayName;
    }

}
