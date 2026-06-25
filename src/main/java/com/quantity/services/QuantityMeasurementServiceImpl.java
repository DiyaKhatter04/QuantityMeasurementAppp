package com.quantity.services;

import com.quantity.interfaces.IMeasurable;
import com.quantity.model.QuantityDTO;
import com.quantity.repository.IQuantityMeasurementRepository;
import com.quantity.repository.QuantityMeasurementCacheRepository;


public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl() {

        repository =
                new QuantityMeasurementCacheRepository();
    }

    @Override
    public <U extends IMeasurable> boolean compare(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    ) {

        return repository.compare(
                quantity1,
                quantity2
        );
    }

    @Override
    public <U extends IMeasurable> QuantityDTO<U> convert(
            QuantityDTO<U> quantity,
            U targetUnit
    ) {

        return repository.convert(
                quantity,
                targetUnit
        );
    }

    @Override
    public <U extends IMeasurable> QuantityDTO<U> add(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    ) {

        return repository.add(
                quantity1,
                quantity2,
                targetUnit
        );
    }

    @Override
    public <U extends IMeasurable> QuantityDTO<U> subtract(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    ) {

        return repository.subtract(
                quantity1,
                quantity2,
                targetUnit
        );
    }

    @Override
    public <U extends IMeasurable> double divide(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    ) {

        return repository.divide(
                quantity1,
                quantity2
        );
    }
}