package com.huawei.parkinglot.service;

import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.repository.CheckInRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }

    public CheckIn checkIn(Vehicle vehicle, ParkingArea parkingArea, LocalDateTime checkInDate) {

        CheckIn checkIn = CheckIn.builder()
                .vehicle(vehicle)
                .parkingArea(parkingArea)
                .checkInDate(checkInDate)
                .build();

        return checkInRepository.save(checkIn);
    }

    public CheckIn getCheckInById(Long id){
    	return checkInRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CheckIn not found"));
    }

    public List<CheckIn> getAll() {
        return checkInRepository.findAll();
    }

}
