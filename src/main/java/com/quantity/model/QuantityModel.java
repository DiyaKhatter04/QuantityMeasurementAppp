package com.quantity.model;

import com.quantity.enums.ArithmeticOperation;
import com.quantity.interfaces.IMeasurable;

import java.util.Objects;

public class QuantityModel<U extends IMeasurable> {

    private static final double EPSILON = 1e-6;

    private final double value;
    private final U unit;

    public QuantityModel(
            double value,
            U unit
    ) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        if (Double.isNaN(value)
                || Double.isInfinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid value"
            );
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public QuantityModel<U> convertTo(
            U targetUnit
    ) {

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        double baseValue =
                unit.convertToBaseUnit(
                        value
                );

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue
                );

        return new QuantityModel<>(
                roundToTwoDecimals(
                        convertedValue
                ),
                targetUnit
        );
    }

    private void validateArithmeticOperands(
            QuantityModel<U> other,
            U targetUnit,
            boolean targetRequired
    ) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Other quantity cannot be null"
            );
        }

        if (targetRequired && targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target unit cannot be null"
            );
        }

        if (unit.getClass()
                != other.unit.getClass()) {

            throw new IllegalArgumentException(
                    "Incompatible quantity types"
            );
        }

        if (Double.isNaN(other.value)
                || Double.isInfinite(other.value)) {

            throw new IllegalArgumentException(
                    "Invalid value"
            );
        }
    }

    private double performBaseArithmetic(
            QuantityModel<U> other,
            ArithmeticOperation operation
    ) {

        unit.validateOperationSupport(
                operation.name()
        );

        double thisBaseValue =
                unit.convertToBaseUnit(
                        value
                );

        double otherBaseValue =
                other.unit.convertToBaseUnit(
                        other.value
                );

        return operation.compute(
                thisBaseValue,
                otherBaseValue
        );
    }

    private double roundToTwoDecimals(
            double value
    ) {

        return Math.round(
                value * 100.0
        ) / 100.0;
    }

    public QuantityModel<U> add(
            QuantityModel<U> other
    ) {

        return add(
                other,
                unit
        );
    }

    public QuantityModel<U> add(
            QuantityModel<U> other,
            U targetUnit
    ) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true
        );

        double resultBaseValue =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.ADD
                );

        double convertedResult =
                targetUnit.convertFromBaseUnit(
                        resultBaseValue
                );

        return new QuantityModel<>(
                roundToTwoDecimals(
                        convertedResult
                ),
                targetUnit
        );
    }

    public QuantityModel<U> subtract(
            QuantityModel<U> other
    ) {

        return subtract(
                other,
                unit
        );
    }

    public QuantityModel<U> subtract(
            QuantityModel<U> other,
            U targetUnit
    ) {

        validateArithmeticOperands(
                other,
                targetUnit,
                true
        );

        double resultBaseValue =
                performBaseArithmetic(
                        other,
                        ArithmeticOperation.SUBTRACT
                );

        double convertedResult =
                targetUnit.convertFromBaseUnit(
                        resultBaseValue
                );

        return new QuantityModel<>(
                roundToTwoDecimals(
                        convertedResult
                ),
                targetUnit
        );
    }

    public double divide(
            QuantityModel<U> other
    ) {

        validateArithmeticOperands(
                other,
                null,
                false
        );

        return performBaseArithmetic(
                other,
                ArithmeticOperation.DIVIDE
        );
    }

    @Override
    public boolean equals(
            Object obj
    ) {

        if (this == obj) {
            return true;
        }

        if (obj == null
                || getClass() != obj.getClass()) {

            return false;
        }

        QuantityModel<?> other =
                (QuantityModel<?>) obj;

        if (unit.getClass()
                != other.unit.getClass()) {

            return false;
        }

        double thisBaseValue =
                unit.convertToBaseUnit(
                        value
                );

        double otherBaseValue =
                other.unit.convertToBaseUnit(
                        other.value
                );

        return Math.abs(
                thisBaseValue
                        - otherBaseValue
        ) < EPSILON;
    }

    @Override
    public int hashCode() {

        double baseValue =
                unit.convertToBaseUnit(
                        value
                );

        long rounded =
                Math.round(
                        baseValue / EPSILON
                );

        return Objects.hash(
                rounded,
                unit.getClass()
        );
    }

    @Override
    public String toString() {

        return "QuantityModel{" +
                "value=" + value +
                ", unit=" +
                unit.getUnitName() +
                '}';
    }
}