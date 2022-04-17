package com.huawei.parkinglot.entity.service;

import com.huawei.parkinglot.dto.ParkingAreaDto;
import com.huawei.parkinglot.dto.PriceListDto;
import com.huawei.parkinglot.dto.converter.ParkingAreaDtoConverter;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.repository.ParkingAreaRepository;
import com.huawei.parkinglot.service.ParkingAreaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaServiceTest {

    @InjectMocks
    ParkingAreaService parkingAreaService;

    @Mock
    ParkingAreaRepository  parkingAreaRepository;

    @Mock
    ParkingAreaDtoConverter parkingAreaDtoConverter;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private ParkingAreaDto fixParkingAreaModel(){

        PriceListDto priceListDto = new PriceListDto();
        priceListDto.setPrice(BigDecimal.valueOf(10));
        priceListDto.setStartHour(10);
        priceListDto.setEndHour(20);

        ParkingAreaDto areaDto = new ParkingAreaDto();
        areaDto.setName("test");
        areaDto.setCapacity(10);
        areaDto.setAvailable(10);

        return areaDto;
    }
    @Test
    void createParkingArea() {
        ParkingArea result = parkingAreaService.createParkingArea(fixParkingAreaModel());
    }

    @Test
    void getAllParkingArea() {

        List<ParkingArea> result = parkingAreaService.getAllParkingArea();
        assertEquals(1, result.size());
    }

    @Test
    void getParkingAreaByName() {

        Mockito.when(parkingAreaService.getParkingAreaByName("test"));
        ParkingAreaDto testName = parkingAreaService.getParkingAreaByName("test");
        assertEquals("Mock user name", testName);

    }

    @Test
    void getDirectorById() {
        PriceListDto priceListDto = new PriceListDto();
        Mockito.when(parkingAreaService.getById(1L));
        ParkingArea testName = parkingAreaService.getById(1L);

        assertEquals(1L, testName);
    }

    @Test
    void deleteParkingArea() {

        Mockito.when(parkingAreaService.deleteParkingArea(1L));
        boolean testName = parkingAreaService.deleteParkingArea(1L);
        assertEquals(true, testName);
    }
}