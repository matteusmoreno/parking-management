package br.com.matteus.parkingmanagement.utils;

import br.com.matteus.parkingmanagement.client.ViaCepClient;
import br.com.matteus.parkingmanagement.entity.Parking;
import br.com.matteus.parkingmanagement.repository.ParkingRepository;
import br.com.matteus.parkingmanagement.request.CreateParkingRequest;
import br.com.matteus.parkingmanagement.request.UpdateParkingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ParkingUtils {

    private final ParkingRepository parkingRepository;
    private final ViaCepClient viaCepClient;
    @Autowired
    public ParkingUtils(ParkingRepository parkingRepository, ViaCepClient viaCepClient) {
        this.parkingRepository = parkingRepository;
        this.viaCepClient = viaCepClient;
    }

    public void setAdressAttributes(Parking parking, String cep) {
        var adress = viaCepClient.getAdress(cep);
        parking.setLogradouro(adress.logradouro());
        parking.setBairro(adress.bairro());
        parking.setLocalidade(adress.localidade());
        parking.setUf(adress.uf());
    }

    public void setCreateAttributes(Parking parking, CreateParkingRequest request) {
        parking.setName(request.name());
        parking.setCnpj(request.cnpj());
        parking.setCep(request.cep());

        setAdressAttributes(parking, request.cep());

        parking.setMotorcycleSpaces(request.motorcycleSpaces());
        parking.setCarSpaces(request.carSpaces());
        parking.setCreatedAt(LocalDateTime.now());
        parking.setActive(true);

        parkingRepository.save(parking);
    }

    public void setUpdateAttributes(Parking parking, UpdateParkingRequest request) {
        if (request.name() != null) {
            parking.setName(request.name());
        }
        if (request.cnpj() != null) {
            parking.setCnpj(request.cnpj());
        }
        if (request.cep() != null) {
            parking.setCep(request.cep());

            setAdressAttributes(parking, request.cep()); // ATUALIZA O ENDEREÇO
        }

        if (request.motorcycleSpaces() != 0) {
            parking.setMotorcycleSpaces(request.motorcycleSpaces());
        }

        if (request.carSpaces() != 0) {
            parking.setCarSpaces(request.carSpaces());
        }

        parking.setUpdatedAt(LocalDateTime.now());
        parkingRepository.save(parking);
    }

    public void setDisableAttributes(Parking parking) {
        parking.setActive(false);
        parking.setDeletedAt(LocalDateTime.now());
        parkingRepository.save(parking);
    }

    public void setEnableAttributes(Parking parking) {
        parking.setActive(true);
        parking.setDeletedAt(null);
        parking.setUpdatedAt(LocalDateTime.now());
        parkingRepository.save(parking);
    }
}
