package com.quantity.repository;

import com.quantity.interfaces.IMeasurable;
import com.quantity.model.QuantityDTO;
import com.quantity.model.QuantityModel;

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    @Override
    public <U extends IMeasurable> boolean compare(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    ) {

        return toModel(quantity1)
                .equals(
                        toModel(quantity2)
                );
    }

    @Override
    public <U extends IMeasurable> QuantityDTO<U> convert(
            QuantityDTO<U> quantity,
            U targetUnit
    ) {

        QuantityModel<U> result =
                toModel(quantity)
                        .convertTo(targetUnit);

        return toDTO(result);
    }

    @Override
    public <U extends IMeasurable> QuantityDTO<U> add(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    ) {

        QuantityModel<U> result =
                toModel(quantity1)
                        .add(
                                toModel(quantity2),
                                targetUnit
                        );

        return toDTO(result);
    }

    @Override
    public <U extends IMeasurable> QuantityDTO<U> subtract(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2,
            U targetUnit
    ) {

        QuantityModel<U> result =
                toModel(quantity1)
                        .subtract(
                                toModel(quantity2),
                                targetUnit
                        );

        return toDTO(result);
    }

    @Override
    public <U extends IMeasurable> double divide(
            QuantityDTO<U> quantity1,
            QuantityDTO<U> quantity2
    ) {

        return toModel(quantity1)
                .divide(
                        toModel(quantity2)
                );
    }

    private <U extends IMeasurable> QuantityModel<U> toModel(
            QuantityDTO<U> dto
    ) {

        return new QuantityModel<>(
                dto.getValue(),
                dto.getUnit()
        );
    }

    private <U extends IMeasurable> QuantityDTO<U> toDTO(
            QuantityModel<U> model
    ) {

        return new QuantityDTO<>(
                model.getValue(),
                model.getUnit()
        );
    }
}