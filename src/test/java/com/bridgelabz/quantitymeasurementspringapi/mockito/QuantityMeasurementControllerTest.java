package com.bridgelabz.quantitymeasurementspringapi.mockito;

import com.bridgelabz.quantitymeasurementspringapi.controllers.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.services.implementors.QuantityMeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities.*;
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
}

