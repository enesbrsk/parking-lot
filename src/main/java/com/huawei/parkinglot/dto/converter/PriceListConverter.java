package com.huawei.parkinglot.dto.converter;

import com.huawei.parkinglot.dto.PriceListDto;
import com.huawei.parkinglot.entity.PriceList;
import org.springframework.stereotype.Component;

@Component
public class PriceListConverter {

    public PriceListDto convert(PriceList priceList){
        return new PriceListDto(
                priceList.getId(),
                priceList.getStartHour(),
                priceList.getEndHour(),
                priceList.getPrice()
        );
    }

}
