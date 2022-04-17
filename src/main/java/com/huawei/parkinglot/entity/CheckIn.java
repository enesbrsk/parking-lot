package com.huawei.parkinglot.entity;

import com.huawei.parkinglot.entity.vehicle.Vehicle;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime checkInDate;
    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name = "parking_area_id", referencedColumnName = "id")
    private ParkingArea parkingArea;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    @OneToOne(mappedBy = "checkIn",fetch = FetchType.LAZY)
    private CheckOut checkOut;


}
