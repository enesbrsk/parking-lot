package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.service.CheckInService;
import com.huawei.parkinglot.service.ParkingAreaService;
import com.huawei.parkinglot.service.VehicleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class CheckInController {

    private final VehicleServiceImpl vehicleService;
    private final CheckInService checkInService;
    private final ParkingAreaService parkingAreaService;

    public CheckInController(VehicleServiceImpl vehicleService, CheckInService checkInService, ParkingAreaService parkingAreaService) {
        this.vehicleService = vehicleService;
        this.checkInService = checkInService;
        this.parkingAreaService = parkingAreaService;
    }

    @GetMapping("/add-check-in")
    public String addNewEmployee(Model model) {
        ParkingArea parkingArea = new ParkingArea();
        Vehicle vehicle = new Vehicle();
        model.addAttribute("checkInVehicle", vehicleService.getAllVehicle());
        model.addAttribute("checkInParking", parkingAreaService.getAllParkingArea());
        model.addAttribute("parkingArea", parkingArea);
        model.addAttribute("vehicle",vehicle);
        return "add-check-in";
    }

    @PostMapping("/create-check-in")
    public String parkingArea(@ModelAttribute("parkingArea") ParkingArea parkingArea,
                                @ModelAttribute("vehicle") Vehicle vehicle,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-parking-area";
        }
        vehicleService.checkIn(vehicle,parkingArea, LocalDateTime.now());
        return "redirect:/list-check-in";
    }

    @GetMapping("/list-check-in")
    public String parkingArea(Model model) {
        model.addAttribute("allCheckIn", checkInService.getAll());
        return "check-in";
    }

}
