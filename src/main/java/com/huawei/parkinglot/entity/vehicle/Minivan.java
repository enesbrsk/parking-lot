package com.huawei.parkinglot.entity.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
public class Minivan extends Vehicle{

}
