package com.quantity;

public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 0.0001;

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

        double feet = convertToFeet();

        return feet / targetUnit.getConversionFactor();
    }

    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Other length is null");
        }

        double totalFeet =
                this.convertToFeet() +
                        other.convertToFeet();

        double result =
                totalFeet / this.unit.getConversionFactor();

        return new QuantityLength(result, this.unit);
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

        return Math.abs(this.convertToFeet()
                - other.convertToFeet()) < EPSILON;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}