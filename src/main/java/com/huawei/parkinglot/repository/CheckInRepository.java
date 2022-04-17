package com.huawei.parkinglot.repository;

import com.huawei.parkinglot.entity.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}
