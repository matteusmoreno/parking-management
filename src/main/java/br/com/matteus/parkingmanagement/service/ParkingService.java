package br.com.matteus.parkingmanagement.service;

import br.com.matteus.parkingmanagement.client.ViaCepClient;
import br.com.matteus.parkingmanagement.entity.Adress;
import br.com.matteus.parkingmanagement.entity.Parking;
import br.com.matteus.parkingmanagement.repository.ParkingRepository;
import br.com.matteus.parkingmanagement.request.CreateParkingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;
    private final ViaCepClient viaCepClient;

    public ParkingService(ParkingRepository parkingRepository, ViaCepClient viaCepClient) {
        this.parkingRepository = parkingRepository;
        this.viaCepClient = viaCepClient;
    }

    public Parking create(CreateParkingRequest request) {
        var parking = new Parking();

        parking.setName(request.name());
        parking.setCnpj(request.cnpj());
        parking.setCep(request.cep());

        var adress = viaCepClient.getAdress(request.cep());
        parking.setLogradouro(adress.logradouro());
        parking.setBairro(adress.bairro());
        parking.setLocalidade(adress.localidade());
        parking.setUf(adress.uf());

        parking.setMotorcycleSpaces(request.motorcycleSpaces());
        parking.setCarSpaces(request.carSpaces());
        parking.setCreatedAt(LocalDateTime.now());
        parking.setActive(true);

        parkingRepository.save(parking);

        return parking;

    }
}
