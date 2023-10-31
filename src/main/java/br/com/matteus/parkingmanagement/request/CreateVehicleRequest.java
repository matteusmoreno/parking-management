package br.com.matteus.parkingmanagement.request;

import br.com.matteus.parkingmanagement.constant.VehicleBrand;
import br.com.matteus.parkingmanagement.constant.VehicleColor;
import br.com.matteus.parkingmanagement.constant.VehicleModel;
import br.com.matteus.parkingmanagement.constant.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateVehicleRequest(
        @NotNull(message = "A marca do veículo é obrigatória")
        VehicleBrand brand,
        @NotNull(message = "O modelo do veículo é obrigatório")
        VehicleModel model,
        @NotNull(message = "A cor do veículo é obrigatória")
        VehicleColor color,
        @NotBlank(message = "A placa do veículo é obrigatória")
        String plate,
        @NotNull(message = "O tipo do veículo é obrigatório")
        VehicleType type) {
}
