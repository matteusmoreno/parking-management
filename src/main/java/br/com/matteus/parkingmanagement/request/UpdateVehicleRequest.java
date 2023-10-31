package br.com.matteus.parkingmanagement.request;

import br.com.matteus.parkingmanagement.constant.VehicleBrand;
import br.com.matteus.parkingmanagement.constant.VehicleColor;
import br.com.matteus.parkingmanagement.constant.VehicleModel;
import br.com.matteus.parkingmanagement.constant.VehicleType;
import jakarta.validation.constraints.NotNull;

public record UpdateVehicleRequest(
        @NotNull(message = "Id is required")
        Long id,
        VehicleBrand brand,
        VehicleModel model,
        VehicleColor color,
        String plate,
        VehicleType type) {
}
