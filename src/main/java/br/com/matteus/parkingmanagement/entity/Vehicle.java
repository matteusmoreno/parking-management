package br.com.matteus.parkingmanagement.entity;

import br.com.matteus.parkingmanagement.constant.VehicleBrand;
import br.com.matteus.parkingmanagement.constant.VehicleColor;
import br.com.matteus.parkingmanagement.constant.VehicleModel;
import br.com.matteus.parkingmanagement.constant.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private VehicleBrand brand;
    @Enumerated(EnumType.STRING)
    private VehicleModel model;
    @Enumerated(EnumType.STRING)
    private VehicleColor color;
    private String plate;
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean isParked;
    private Boolean active;

}
