package com.bridgelabz.quantitymeasurementspringapi.mockito;

import com.bridgelabz.quantitymeasurementspringapi.controllers.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;
import com.bridgelabz.quantitymeasurementspringapi.services.implementors.QuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities.*;
import static com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void testingGetAllMainQuantitiesMethod() throws Exception {
        Quantities[] array = {LENGTH, VOLUME, WEIGHT, TEMPERATURE};
        given(quantityMeasurementService.getAllMainUnits()).willReturn(array);
        mockMvc.perform(get("/units/mainunit"))
                .andExpect(content().json(Arrays.toString(array)));
    }

    @Test
    public void testingGetAllSubQuantitiesMethod() throws Exception {
        List<SubQuantities> list = Arrays.asList(FEET,INCH,GRAM,KILOGRAM);
        given(quantityMeasurementService.getAllSubUnits(LENGTH)).willReturn(list);
        mockMvc.perform(get("/units?unit=LENGTH"))
                .andExpect(content().json(String.valueOf(list)));
    }
}


