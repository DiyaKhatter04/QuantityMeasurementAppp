package com.quantity;

public class QuantityMeasurementApp {

    public static void demonstrateConversion(
            QuantityLength length,
            LengthUnit targetUnit) {

        QuantityLength result =
                length.convertTo(targetUnit);

        System.out.println(
                length +
                        ".convertTo(" +
                        targetUnit +
                        ") -> " +
                        result);
    }

    public static void demonstrateAddition(
            QuantityLength length1,
            QuantityLength length2,
            LengthUnit targetUnit) {

        QuantityLength result =
                length1.add(length2, targetUnit);

        System.out.println(
                length1 +
                        ".add(" +
                        length2 +
                        ", " +
                        targetUnit +
                        ") -> " +
                        result);
    }

    public static void main(String[] args) {

        demonstrateConversion(
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET),

                LengthUnit.INCHES);

        demonstrateAddition(
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET),

                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES),

                LengthUnit.FEET);
    }
}