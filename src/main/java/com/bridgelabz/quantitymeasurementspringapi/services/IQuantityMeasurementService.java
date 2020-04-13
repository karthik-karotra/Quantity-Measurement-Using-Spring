package com.bridgelabz.quantitymeasurementspringapi.services;

import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;/**/

import java.util.List;
import java.util.stream.Stream;

public interface IQuantityMeasurementService {

    Quantities[] getAllMainUnits();
    List<SubQuantities> getAllSubUnits(Quantities unit);
}
