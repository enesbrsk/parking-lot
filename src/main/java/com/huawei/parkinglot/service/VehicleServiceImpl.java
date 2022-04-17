package com.huawei.parkinglot.service;

import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.repository.VehicleRepository;
import com.huawei.parkinglot.service.base.VehicleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleServiceImpl extends VehicleService {

	private final CheckInService checkInService;
	private final CheckOutService checkOutService;
	private final ParkingAreaService parkingAreaService;
	private final VehicleRepository vehicleRepository;


	public VehicleServiceImpl(CheckInService checkInService, CheckOutService checkOutService,
							  ParkingAreaService parkingAreaService, VehicleRepository vehicleRepository) {
		this.checkInService = checkInService;
		this.checkOutService = checkOutService;
		this.parkingAreaService = parkingAreaService;
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public CheckIn checkIn(Vehicle vehicle, ParkingArea parkingArea, LocalDateTime checkInDate) {

		if (vehicle.getId() == null) {
			vehicleRepository.save(vehicle);
		}
		return checkInService.checkIn(vehicle,parkingArea,checkInDate);
	}

	@Override
	public void checkOut(Long id, LocalDateTime checkOutDateTime) {

		CheckIn checkIn = checkInService.getCheckInById(id);

		double totalPrice = priceCalculation(checkIn,checkOutDateTime);
		checkOutService.checkOut(checkIn,checkOutDateTime,totalPrice);

		parkingAreaService.updateCapacity(checkIn.getParkingArea().getId());

	}

	public Vehicle createVehicle(Vehicle vehicle){
		return vehicleRepository.save(vehicle);
	}

	public List<Vehicle> getAllVehicle(){
		return vehicleRepository.findAll();
	}
}
