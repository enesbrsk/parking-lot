package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutRepository extends JpaRepository<CheckOut,Long> {
}
