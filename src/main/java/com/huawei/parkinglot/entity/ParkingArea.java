package com.huawei.parkinglot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ParkingArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer capacity;
    private Integer available;
    private String city;

    @JsonManagedReference
    @OneToMany(mappedBy = "parkingArea", fetch = EAGER, cascade = CascadeType.REMOVE)
    private List<PriceList> priceList = new ArrayList<>();

}
