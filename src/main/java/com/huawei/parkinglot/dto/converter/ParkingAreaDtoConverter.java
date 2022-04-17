package com.huawei.parkinglot.dto.converter;

import com.huawei.parkinglot.dto.ParkingAreaDto;
import com.huawei.parkinglot.dto.PriceListDto;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.PriceList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingAreaDtoConverter {

    public ParkingAreaDto convert(ParkingArea area){
        return new ParkingAreaDto(
                area.getId(),
                area.getName(),
                area.getCapacity(),
                area.getAvailable(),
                area.getCity());
    }

    private List<PriceListDto> getPriceList(List<PriceList> priceLists){
        return priceLists.stream()
                .map(p -> new PriceListDto(
                        p.getId(),
                        p.getStartHour(),
                        p.getEndHour(),
                        p.getPrice()
                )).collect(Collectors.toList());
    }

}
