package org.example.controller;

import org.example.service.IQuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class QuantityMeasurementControllerTest {

    @MockitoBean
    private IQuantityMeasurementService service;

    @Test
    void controllerLoads() {
        assertNotNull(service);
    }
}