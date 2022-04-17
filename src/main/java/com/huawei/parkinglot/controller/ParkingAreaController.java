package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.dto.ParkingAreaDto;
import com.huawei.parkinglot.service.ParkingAreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParkingAreaController {

    private final ParkingAreaService parkingAreaService;

    public ParkingAreaController(ParkingAreaService parkingAreaService) {
        this.parkingAreaService = parkingAreaService;
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        ParkingAreaDto parkingAreaDto = new ParkingAreaDto();
        model.addAttribute("parkingAreaDto", parkingAreaDto);
        return "add-parking-area";
    }

    @PostMapping("/parkingArea")
    public String parkingArea(@ModelAttribute("parkingAreaDto") ParkingAreaDto parkingAreaDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-parking-area";
        }
        parkingAreaService.createParkingArea(parkingAreaDto);
        return "redirect:/parking-area";
    }

    @GetMapping("/parking-area")
    public String parkingArea(Model model) {

        model.addAttribute("allParkingArea", parkingAreaService.getAllParkingArea());

        return "parking-area";
    }

}
