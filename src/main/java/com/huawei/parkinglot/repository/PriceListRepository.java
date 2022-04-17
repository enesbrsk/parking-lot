package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceListRepository extends JpaRepository<PriceList, Long>  {

    List<PriceList> getByParkingAreaId(Long parkingAreaId);

}
