package com.bridgelabz.quantitymeasurementspringapi.services.implementors;

import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.services.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public Quantities[] getAllMainUnits() {
        return Quantities.values();
    }
}
