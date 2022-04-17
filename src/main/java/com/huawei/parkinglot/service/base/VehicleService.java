package com.huawei.parkinglot.service.base;

import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.PriceList;
import com.huawei.parkinglot.entity.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Calculations will be placed on each vehicle type
 */
public abstract class VehicleService {

	public abstract CheckIn checkIn(Vehicle vehicle, ParkingArea parkingArea, LocalDateTime checkInDate);
	public abstract void checkOut(Long id, LocalDateTime checkOutDate);

	public Long range(LocalDateTime checkIn,LocalDateTime checkOut) {
		return ChronoUnit.MINUTES.between(checkIn, checkOut);
	}

	public Integer percentage(Vehicle vehicle) {

		Integer percantege = 0;
		switch (vehicle.getType()) {
			case SUV:
				percantege = 10;
				break;
			case MINIVAN:
				percantege = 15;
				break;
		}
		return percantege;
	}


	public double priceCalculation(CheckIn checkIn, LocalDateTime checkOutDate) {

		Integer currentTime  = Math.toIntExact(range(checkIn.getCheckInDate(), checkOutDate));
		Integer percentage = percentage(checkIn.getVehicle());

		double totalPrice = 0;

		for (PriceList price : checkIn.getParkingArea().getPriceList()){
			if (price.getStartHour()*60 <= currentTime && price.getEndHour()*60 >= currentTime) {
				totalPrice = ((percentage * price.getPrice().doubleValue()) / 100) + price.getPrice().doubleValue();
				break;
			}
		}
		return totalPrice;
	}
}
