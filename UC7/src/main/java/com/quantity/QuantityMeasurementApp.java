package com.quantity;

public class QuantityMeasurementApp {

    public static void demonstrateAddition(
            QuantityLength length1,
            QuantityLength length2,
            LengthUnit targetUnit) {

        QuantityLength result =
                length1.add(length2, targetUnit);

        System.out.println(
                "Input: add(" +
                        length1 + ", " +
                        length2 + ", " +
                        targetUnit + ")" +
                        " -> Output: " +
                        result);
    }

    public static void main(String[] args) {

        demonstrateAddition(
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET),

                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES),

                LengthUnit.FEET);

        demonstrateAddition(
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET),

                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES),

                LengthUnit.INCHES);

        demonstrateAddition(
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET),

                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES),

                LengthUnit.YARDS);
    }
}