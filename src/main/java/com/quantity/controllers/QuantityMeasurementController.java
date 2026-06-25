package com.quantity.controllers;

import com.quantity.interfaces.IMeasurable;
import com.quantity.model.QuantityDTO;
import com.quantity.services.IQuantityMeasurementService;
import com.quantity.services.QuantityMeasurementServiceImpl;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController() {
        this.service = new QuantityMeasurementServiceImpl();
    }

    public <U extends IMeasurable> boolean compare(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    ) {

        return service.compare(
                quantity1,
                quantity2
        );
    }

    public <U extends IMeasurable> QuantityDTO<U> convert(
            QuantityDTO<U> quantity,
            U targetUnit
    ) {

        return service.convert(
                quantity,
                targetUnit
        );
    }

    public <U extends IMeasurable> QuantityDTO<U> add(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    ) {

        return service.add(
                quantity1,
                quantity2,
                targetUnit
        );
    }

    public <U extends IMeasurable> QuantityDTO<U> subtract(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    ) {

        return service.subtract(
                quantity1,
                quantity2,
                targetUnit
        );
    }

    public <U extends IMeasurable> double divide(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    ) {

        return service.divide(
                quantity1,
                quantity2
        );
    }
}