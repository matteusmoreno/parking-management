package br.com.matteus.parkingmanagement.client;

import br.com.matteus.parkingmanagement.dto.Adress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
    @GetMapping("{cep}/json")
    Adress getAdress(@PathVariable String cep);
}
