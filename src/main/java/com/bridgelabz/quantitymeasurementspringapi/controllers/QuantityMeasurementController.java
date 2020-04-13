package com.bridgelabz.quantitymeasurementspringapi.controllers;

import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;
import com.bridgelabz.quantitymeasurementspringapi.services.IQuantityMeasurementService;
import com.bridgelabz.quantitymeasurementspringapi.services.implementors.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    public void settingObjectsThatAreMocked(QuantityMeasurementService quantityMeasurementService) {
        this.quantityMeasurementService = quantityMeasurementService;
    }
}
