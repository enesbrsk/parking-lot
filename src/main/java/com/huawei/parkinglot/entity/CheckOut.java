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
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime checkOutDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "check_in_id", referencedColumnName = "id")
    private CheckIn checkIn;
    private double fee;


}