package com.quantity;

public class QuantityMeasurementApp {

    public static void demonstrateWeightEquality(
            QuantityWeight weight1,
            QuantityWeight weight2) {

        System.out.println(
                weight1 +
                        ".equals(" +
                        weight2 +
                        ") -> " +
                        weight1.equals(weight2));
    }

    public static void demonstrateWeightConversion(
            QuantityWeight weight,
            WeightUnit targetUnit) {

        QuantityWeight result =
                weight.convertTo(targetUnit);

        System.out.println(
                weight +
                        ".convertTo(" +
                        targetUnit +
                        ") -> " +
                        result);
    }

    public static void demonstrateWeightAddition(
            QuantityWeight weight1,
            QuantityWeight weight2,
            WeightUnit targetUnit) {

        QuantityWeight result =
                weight1.add(weight2, targetUnit);

        System.out.println(
                weight1 +
                        ".add(" +
                        weight2 +
                        ", " +
                        targetUnit +
                        ") -> " +
                        result);
    }

    public static void main(String[] args) {

        demonstrateWeightEquality(
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM),

                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM));

        demonstrateWeightConversion(
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM),

                WeightUnit.POUND);

        demonstrateWeightAddition(
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM),

                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM),

                WeightUnit.KILOGRAM);
    }
}