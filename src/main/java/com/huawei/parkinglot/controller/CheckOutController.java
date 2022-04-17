package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.entity.CheckIn;
import com.huawei.parkinglot.entity.CheckOut;
import com.huawei.parkinglot.entity.ParkingArea;
import com.huawei.parkinglot.service.CheckInService;
import com.huawei.parkinglot.service.CheckOutService;
import com.huawei.parkinglot.service.VehicleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class CheckOutController {

    private final VehicleServiceImpl vehicleService;
    private final CheckOutService checkOutService;
    private final CheckInService checkInService;

    public CheckOutController(VehicleServiceImpl vehicleService, CheckOutService checkOutService, CheckInService checkInService) {
        this.vehicleService = vehicleService;
        this.checkOutService = checkOutService;
        this.checkInService = checkInService;
    }

    @GetMapping("/add-check-out")
    public String addNewEmployee(Model model) {
        CheckOut checkOut = new CheckOut();
        model.addAttribute("checkOut", checkOut);
        model.addAttribute("allCheckIn", checkInService.getAll());
        return "add-check-out";
    }

    @PostMapping("/create-check-out")
    public String parkingArea(@ModelAttribute("checkOut") CheckIn checkIn,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-check-out";
        }
        vehicleService.checkOut(checkIn.getId(), LocalDateTime.now());
        return "redirect:/list-check-out";
    }

    @GetMapping("/list-check-out")
    public String parkingArea(Model model) {
        model.addAttribute("allCheckOut", checkOutService.checkOutList());
        return "check-out";
    }
}
