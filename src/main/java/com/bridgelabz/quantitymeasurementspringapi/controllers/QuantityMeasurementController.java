package com.bridgelabz.quantitymeasurementspringapi.controllers;

import com.bridgelabz.quantitymeasurementspringapi.dto.ConvertDTO;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;
import com.bridgelabz.quantitymeasurementspringapi.services.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("/units/mainunit")
    public Quantities[] getAllMainQuantities() {
        return quantityMeasurementService.getAllMainUnits();
    }

    @GetMapping("/units")
    public List<SubQuantities> getAllSubQuantities(@RequestParam(value = "unit") Quantities unit) {
        return quantityMeasurementService.getAllSubUnits(unit);
    }

   @PostMapping("/units/convert")
    public Double convert(@RequestBody ConvertDTO convertDTO) {
       return quantityMeasurementService.getConvertedValueOfUnit(convertDTO);
   }
}
