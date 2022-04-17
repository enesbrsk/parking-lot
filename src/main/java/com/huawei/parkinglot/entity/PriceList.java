package com.huawei.parkinglot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer startHour;
    private Integer endHour;
    private BigDecimal price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parking_area_id")
    private ParkingArea parkingArea;

}
