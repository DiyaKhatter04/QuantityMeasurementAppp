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

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double valueInFeet = convertToFeet();

        return valueInFeet / targetUnit.getConversionFactor();
    }

    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        QuantityLength quantity =
                new QuantityLength(value, source);

        return quantity.convertTo(target);
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