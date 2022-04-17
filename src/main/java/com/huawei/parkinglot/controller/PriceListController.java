package com.huawei.parkinglot.controller;

import com.huawei.parkinglot.dto.ParkingAreaDto;
import com.huawei.parkinglot.dto.PriceListDto;
import com.huawei.parkinglot.service.PriceListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PriceListController {

    private final PriceListService priceListService;

    public PriceListController(PriceListService priceListService) {
        this.priceListService = priceListService;
    }


    @GetMapping("/price-list/{id}")
    public String parkingArea(@PathVariable("id") Long id, Model model){

        model.addAttribute("getByPriceList", priceListService.getByParkingAreaId(id));

        return "price-list";
    }

    @GetMapping("/addNewPrice/{id}")
    public String addNewEmployee(@PathVariable("id") Long id,Model model) {
        PriceListDto priceListDto = new PriceListDto();
        model.addAttribute("priceListDto", priceListDto);
        return "add-price-list";
    }

    @PostMapping("/add-price-list/{id}")
    public String parkingArea(@ModelAttribute("priceListDto") PriceListDto priceListDto,
                              @PathVariable("id") Long id,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-price-list";
        }
        priceListService.createPriceList(priceListDto,id);
        return "redirect:/price-list/"+id;
    }

}
