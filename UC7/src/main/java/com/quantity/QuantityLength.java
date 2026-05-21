package com.quantity;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.01;

    public QuantityLength(double value, LengthUnit unit) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    private double convertToFeet() {
        return value * unit.getConversionFactor();
    }

    public double convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double feetValue = convertToFeet();

        return feetValue / targetUnit.getConversionFactor();
    }

    // UC6 method
    public QuantityLength add(QuantityLength other) {

        return add(other, this.unit);
    }

    // UC7 overloaded method
    public QuantityLength add(
            QuantityLength other,
            LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException("Other object cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double totalFeet =
                this.convertToFeet()
                        + other.convertToFeet();

        double result =
                totalFeet / targetUnit.getConversionFactor();

        return new QuantityLength(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof QuantityLength)) {
            return false;
        }

        QuantityLength other = (QuantityLength) obj;

        return Math.abs(
                this.convertToFeet()
                        - other.convertToFeet())
                < EPSILON;
    }

    @Override
    public String toString() {

        return "Quantity(" +
                value +
                ", " +
                unit +
                ")";
    }
}