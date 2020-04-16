package com.bridgelabz.quantitymeasurementspringapi.mockito;

import com.bridgelabz.quantitymeasurementspringapi.dto.ConvertDTO;
import com.bridgelabz.quantitymeasurementspringapi.dto.ResponseDto;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities;
import com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities;
import com.bridgelabz.quantitymeasurementspringapi.services.implementors.QuantityMeasurementService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static com.bridgelabz.quantitymeasurementspringapi.enumerations.Quantities.*;
import static com.bridgelabz.quantitymeasurementspringapi.enumerations.SubQuantities.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class QuantityMeasurementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuantityMeasurementService quantityMeasurementService;

    @Test
    public void givenQuantityMeasurment_ShouldReturnAllTheMainUnits() throws Exception {
        Quantities[] array = {LENGTH, VOLUME, WEIGHT, TEMPERATURE};
        given(quantityMeasurementService.getAllMainUnits()).willReturn(array);
        mockMvc.perform(get("/units/mainunit"))
                .andExpect(content().json(Arrays.toString(array)));
    }

    @Test
    public void whenGivenAnyMainUnitValue_ShouldReturnAllTheSubUnits() throws Exception {
        List<SubQuantities> list = Arrays.asList(FEET, INCH, GRAM, KILOGRAM);
        given(quantityMeasurementService.getAllSubUnits(LENGTH)).willReturn(list);
        mockMvc.perform(get("/units?unit=LENGTH"))
                .andExpect(content().json(String.valueOf(list)));
    }

    @Test
    public void whenGivenBaseAndTargetUnitTypeAlongWithTheBaseUnitValueOtherThanTemperature_ShouldReturnConvertedValue() throws Exception {
        Gson gson = new Gson();
        ConvertDTO convertDTO = new ConvertDTO(1.0, FEET, INCH);
        String jsonConvertDTO = gson.toJson(convertDTO);
        ResponseDto responseDto = new ResponseDto(12, "Response Successful", 200);
        String jsonResponseDTO = gson.toJson(responseDto);
        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(12.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }

    @Test
    public void whenGivenBaseAndTargetUnitTypeAlongWithTheBaseUnitValueOfTemperature_ShouldReturnConvertedValue() throws Exception {
        Gson gson = new Gson();
        ConvertDTO convertDTO = new ConvertDTO(202.0, FAHRENHEIT, CELSIUS);
        String jsonConvertDTO = gson.toJson(convertDTO);
        ResponseDto responseDto = new ResponseDto(100, "Response Successful", 200);
        String jsonResponseDTO = gson.toJson(responseDto);
        when(quantityMeasurementService.getConvertedValueOfUnit(any())).thenReturn(100.0);
        mockMvc.perform(post("/units/convert")
                .content(jsonConvertDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonResponseDTO));
    }
}


