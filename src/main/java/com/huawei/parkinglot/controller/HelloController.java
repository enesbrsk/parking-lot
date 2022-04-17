package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.dto.ParkingAreaDto;
import com.huawei.parkinglot.dto.PriceListDto;
import com.huawei.parkinglot.enm.EnumVehicle;
import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.service.CheckInService;
import com.huawei.parkinglot.service.ParkingAreaService;
import com.huawei.parkinglot.service.PriceListService;
import com.huawei.parkinglot.service.VehicleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("v1/")
public class HelloController {

    private final ParkingAreaService parkingAreaService;
    private final PriceListService priceListService;
    private final CheckInService checkInService;
    private  final VehicleServiceImpl sedanVehicleService;

    public HelloController(ParkingAreaService parkingAreaService, PriceListService priceListService, CheckInService checkInService, VehicleServiceImpl sedanVehicleService) {
        this.parkingAreaService = parkingAreaService;
        this.priceListService = priceListService;
        this.checkInService = checkInService;
        this.sedanVehicleService = sedanVehicleService;
    }

    @GetMapping("test")
    public List<CheckIn> helloWorld(){

        Vehicle vehicle = new Vehicle();

        vehicle.setType(EnumVehicle.SUV);

        Random r=new Random(); //random sınıfı
        int a=r.nextInt(10);

        vehicle.setLicensePlate(String.valueOf(a));

        PriceListDto priceListDto = new PriceListDto();
        priceListDto.setPrice(BigDecimal.valueOf(10));
        priceListDto.setStartHour(0);
        priceListDto.setEndHour(2);

        ParkingAreaDto areaDto = new ParkingAreaDto();
        areaDto.setName("test");
        areaDto.setCapacity(10);
        areaDto.setAvailable(10);
        areaDto.setPriceList(List.of(priceListDto));

        ParkingArea test = parkingAreaService.createParkingArea(areaDto);
        PriceListDto test2 = priceListService.createPriceList(priceListDto, test.getId());

        CheckIn checkInss = sedanVehicleService.checkIn(vehicle, test, LocalDateTime.now());
        LocalDateTime checkOut = LocalDateTime.of(2022, 4, 15, 23, 00, 00);

        sedanVehicleService.checkOut(3L,checkOut);

        return Collections.singletonList(checkInss);
    }
}
