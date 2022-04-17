package com.huawei.parkinglot.service;

import com.huawei.parkinglot.dto.ParkingAreaDto;
import com.huawei.parkinglot.dto.converter.ParkingAreaDtoConverter;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.repository.ParkingAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingAreaService {

    private final ParkingAreaRepository parkingAreaRepository;
    private final ParkingAreaDtoConverter parkingAreaDtoConverter;

    public ParkingAreaService(ParkingAreaRepository parkingAreaRepository, ParkingAreaDtoConverter parkingAreaDtoConverter) {
        this.parkingAreaRepository = parkingAreaRepository;
        this.parkingAreaDtoConverter = parkingAreaDtoConverter;
    }

   public ParkingArea createParkingArea(ParkingAreaDto areaDto) {

        ParkingArea parkingArea = ParkingArea.builder()
                .available(areaDto.getAvailable())
                .capacity(areaDto.getCapacity())
                .name(areaDto.getName())
                .city(areaDto.getCity())
                .build();

        //return parkingAreaDtoConverter.convert(parkingAreaRepository.save(parkingArea));
       return parkingAreaRepository.save(parkingArea);
    }

    public ParkingAreaDto updateParkingArea(ParkingAreaDto areaDto) {

        if (areaDto == null) {
            throw new IllegalArgumentException("Parking area not null");
        }

        ParkingArea parkingArea = ParkingArea.builder()
                .id(areaDto.getId())
                .available(areaDto.getAvailable())
                .capacity(areaDto.getCapacity())
                .name(areaDto.getName())
                .city(areaDto.getCity())
                .build();

        return parkingAreaDtoConverter.convert(parkingAreaRepository.save(parkingArea));
    }

    public boolean updateCapacity(Long id) {

        ParkingArea parkingArea = parkingAreaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Parking area not found"));

        parkingArea.setAvailable(parkingArea.getAvailable()-1);

        parkingAreaRepository.save(parkingArea);

        return true;
    }

    public List<ParkingArea> getAllParkingArea(){
        return  parkingAreaRepository.findAll();
    }

    public ParkingAreaDto getParkingAreaByName(String areaName) {

        return parkingAreaDtoConverter.convert(parkingAreaRepository.getParkingAreaByName(areaName)
                .orElseThrow(() -> new IllegalArgumentException("Parking area not found")));
    }

    public ParkingArea getById(Long id){
        return parkingAreaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bad"));
    }

    public boolean deleteParkingArea(Long id) {
        parkingAreaRepository.deleteById(id);
        return true;
    }



}
