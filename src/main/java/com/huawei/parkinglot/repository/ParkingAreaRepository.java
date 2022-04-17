package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingAreaRepository extends JpaRepository<ParkingArea,Long> {

    Optional<ParkingArea> getParkingAreaByName(String areaName);

/*
    void createParkingArea(ParkingArea area);

    void getParkingAreaByName(String parkingAreaName);

    void getDailyIncome(String parkingAreaName, String date);

    void updateParkingArea(Long id);

    void deleteParkingArea(String parkingAreaName);*/
}
