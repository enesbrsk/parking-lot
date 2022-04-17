package com.huawei.parkinglot.entity.service;

import com.huawei.parkinglot.enm.EnumVehicle;
import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.PriceList;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class VehicleServiceTest {

    @Test
    void range() {

        LocalDateTime checkOut = LocalDateTime.of(2022, 9, 9, 12, 20, 00);
        LocalDateTime checkIn = LocalDateTime.of(2022, 9, 9, 11, 20, 00);

        ChronoUnit.MINUTES.between(checkIn, checkOut);

        assertEquals(ChronoUnit.MINUTES.between(checkIn, checkOut), 60);
    }

    @Test
    void percentage() {

        Vehicle vehicle = new Vehicle();
        vehicle.setType(EnumVehicle.SUV);

        Integer percantege = 0;
        switch (vehicle.getType()) {
            case SUV:
                percantege = 10;
                break;
            case MINIVAN:
                percantege = 15;
                break;
        }
        assertEquals(percantege, 10);
    }

    @Test
    void priceCalculation() {

        Integer currentTime  = 60;
        Integer percentage = 0;
        double totalPrice = 0;

        PriceList priceList = new PriceList();
        priceList.setPrice(BigDecimal.valueOf(10));
        priceList.setStartHour(0);
        priceList.setEndHour(3);

        ParkingArea parkingArea = new ParkingArea();
        parkingArea.setPriceList(Collections.singletonList(priceList));

        CheckIn checkIn = new CheckIn();
        checkIn.setParkingArea(parkingArea);

        for (PriceList price : checkIn.getParkingArea().getPriceList()){

            if (price.getStartHour()*60 <= currentTime && price.getEndHour()*60 >= currentTime) {
                totalPrice = ((percentage * price.getPrice().doubleValue()) / 100) + price.getPrice().doubleValue();

                break;
            }
        }
            assertEquals(totalPrice, 10.0);

    }
}