package com.bridgelabz.quantitymeasurementspringapi.mockito;

import com.bridgelabz.quantitymeasurementspringapi.controllers.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.services.implementors.QuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void testingGetAllMainQuantitiesMethod() throws Exception {
        Quantities[] array = {LENGTH, VOLUME, WEIGHT, TEMPERATURE};
        given(quantityMeasurementService.getAllMainUnits()).willReturn(array);
        mvc.perform(get("/units/mainunit"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(Arrays.toString(array)));
    }


 /*   @Mock
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
    }*/
}


