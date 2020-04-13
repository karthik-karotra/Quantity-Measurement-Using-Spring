package com.bridgelabz.quantitymeasurementspringapi.mockito;

import com.bridgelabz.quantitymeasurementspringapi.controllers.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;
import com.bridgelabz.quantitymeasurementspringapi.services.implementors.QuantityMeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities.*;
import static com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuantityMeasurementControllerTest {
    @Mock
    QuantityMeasurementService quantityMeasurementService;

    @InjectMocks
    QuantityMeasurementController quantityMeasurementController;

    @BeforeEach
    public void setUp() {
        quantityMeasurementService = mock(QuantityMeasurementService.class);
        quantityMeasurementController = new QuantityMeasurementController();
        quantityMeasurementController.settingObjectsThatAreMocked(quantityMeasurementService);
    }

    @Test
    public void testingGetAllMainQuantitiesMethod() {
        Quantities[] array = new Quantities[]{LENGTH, VOLUME, WEIGHT, TEMPERATURE};
        when(quantityMeasurementService.getAllMainUnits()).thenReturn(array);
        Quantities[] allUnits = quantityMeasurementController.getAllMainQuantities();
        assertEquals(array, allUnits);
    }

    @Test
    public void testingGetAllSubQuantitiesMethod1() {
        List<SubQuantities> list = Arrays.asList(FEET,INCH,GRAM,KILOGRAM);
        when(quantityMeasurementService.getAllSubUnits(LENGTH)).thenReturn(list);
        List<SubQuantities> allSubUnits = quantityMeasurementController.getAllSubQuantities(LENGTH);
        assertEquals(list, allSubUnits);
    }
}


