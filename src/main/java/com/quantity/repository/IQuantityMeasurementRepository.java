package com.quantity.repository;

import com.quantity.interfaces.IMeasurable;
import com.quantity.model.QuantityDTO;

public interface IQuantityMeasurementRepository {

    <U extends IMeasurable> boolean compare(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    );

    <U extends IMeasurable> QuantityDTO<U> convert(
            QuantityDTO<U> quantity,
            U targetUnit
    );

    <U extends IMeasurable> QuantityDTO<U> add(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    );

    <U extends IMeasurable> QuantityDTO<U> subtract(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    );

    <U extends IMeasurable> double divide(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    );
}