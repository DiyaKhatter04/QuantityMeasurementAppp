package com.quantity;

public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toUnit) {

        double result =
                QuantityLength.convert(value, fromUnit, toUnit);

        System.out.println(
                "Input: " + value + " " + fromUnit +
                        " -> Output: " + result + " " + toUnit
        );
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(
                1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES);

        demonstrateLengthConversion(
                3.0,
                LengthUnit.YARDS,
                LengthUnit.FEET);

        demonstrateLengthConversion(
                36.0,
                LengthUnit.INCHES,
                LengthUnit.YARDS);

        demonstrateLengthConversion(
                1.0,
                LengthUnit.CENTIMETERS,
                LengthUnit.INCHES);
    }
}