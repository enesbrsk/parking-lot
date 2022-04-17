package com.huawei.parkinglot.service;

import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.CheckOut;
import com.huawei.parkinglot.repository.CheckOutRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CheckOutService {

    private final CheckOutRepository checkOutRepository;

    public CheckOutService(CheckOutRepository checkOutRepository) {
        this.checkOutRepository = checkOutRepository;
    }

    public CheckOut checkOut(CheckIn checkIn, LocalDateTime checkOutDateTime,double totalPrice) {

        CheckOut checkOut = CheckOut.builder()
                .checkIn(checkIn)
                .checkOutDate(checkOutDateTime)
                .fee(totalPrice)
                .build();

        return checkOutRepository.save(checkOut);
    }

    public List<CheckOut> checkOutList(){
    	return checkOutRepository.findAll();
    }

}
