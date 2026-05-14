package com.quantity;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        QuantityLength result =
                feet.add(inches);

        System.out.println(result);
    }
}