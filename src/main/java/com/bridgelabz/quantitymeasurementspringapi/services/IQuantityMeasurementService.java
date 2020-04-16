package com.bridgelabz.quantitymeasurementspringapi.services;

import com.bridgelabz.quantitymeasurementspringapi.dto.ConvertDTO;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;/**/
import java.util.List;

public interface IQuantityMeasurementService {

    Quantities[] getAllMainUnits();
    List<SubQuantities> getAllSubUnits(Quantities unit);
    Double getConvertedValueOfUnit(ConvertDTO convertDTO);
}
