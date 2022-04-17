package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.entity.vehicle.Vehicle;
import com.huawei.parkinglot.service.VehicleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {

    private final VehicleServiceImpl vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/addVehicle")
    public String addVehicle(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "add-vehicle";
    }

    @PostMapping("/newVehicle")
    public String parkingArea(@ModelAttribute("vehicle") Vehicle vehicle, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-vehicle";
        }
        vehicleService.createVehicle(vehicle);
        return "redirect:/all-vehicle";
    }


    @GetMapping("/all-vehicle")
    public String vehicle(Model model) {
        model.addAttribute("allVehicle", vehicleService.getAllVehicle());
        return "vehicle";
    }
}
