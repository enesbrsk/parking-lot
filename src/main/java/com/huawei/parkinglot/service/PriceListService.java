package com.huawei.parkinglot.service;

import com.huawei.parkinglot.dto.PriceListDto;
import com.huawei.parkinglot.dto.converter.PriceListConverter;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.PriceList;
import com.huawei.parkinglot.repository.PriceListRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PriceListService {

    private final ParkingAreaService parkingAreaService;
    private final PriceListRepository priceListRepository;
    private final PriceListConverter priceListConverter;

    public PriceListService(ParkingAreaService parkingAreaService, PriceListRepository priceListRepository, PriceListConverter priceListConverter) {
        this.parkingAreaService = parkingAreaService;
        this.priceListRepository = priceListRepository;
        this.priceListConverter = priceListConverter;
    }

    public PriceListDto createPriceList(PriceListDto priceListDto, Long id) {

        PriceList priceList = PriceList.builder()
                .startHour(priceListDto.getStartHour())
                .endHour(priceListDto.getEndHour())
                .price(priceListDto.getPrice())
                .parkingArea(parkingAreaService.getById(id))
                .build();

        return priceListConverter.convert(priceListRepository.save(priceList));
    }

    public List<PriceList> getByParkingAreaId(Long id){
         return priceListRepository.getByParkingAreaId(id);
    }
}
