package com.bridgelabz.quantitymeasurementspringapi.services.implementors;

import com.bridgelabz.quantitymeasurementspringapi.dto.ConvertDTO;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;
import com.bridgelabz.quantitymeasurementspringapi.services.IQuantityMeasurementService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public Quantities[] getAllMainUnits() {
        return Quantities.values();
    }

    @Override
    public List<SubQuantities> getAllSubUnits(Quantities unit) {
        return Arrays.stream(SubQuantities.values())
                .filter(units -> units.mainQuantityType.equals(unit))
                .collect(Collectors.toList());
    }

    @Override
    public Double getConvertedValueOfUnit(ConvertDTO convertDTO) {
        return convertDTO.valueOfInitialUnit * convertDTO.baseUnit.conversionFactor / convertDTO.targetUnit.conversionFactor;
    }
}
