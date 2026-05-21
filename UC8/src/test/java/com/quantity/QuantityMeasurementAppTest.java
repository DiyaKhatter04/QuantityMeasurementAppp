package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testLengthUnitEnum_FeetConstant() {

        assertEquals(
                1.0,
                LengthUnit.FEET.getConversionFactor());
    }

    @Test
    void testConvertToBaseUnit_InchesToFeet() {

        assertEquals(
                1.0,
                LengthUnit.INCHES
                        .convertToBaseUnit(12.0),
                0.01);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {

        assertEquals(
                12.0,
                LengthUnit.INCHES
                        .convertFromBaseUnit(1.0),
                0.01);
    }

    @Test
    void testQuantityLengthRefactored_Equality() {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    void testQuantityLengthRefactored_ConvertTo() {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES),

                result);
    }

    @Test
    void testQuantityLengthRefactored_Add() {

        QuantityLength result =

                new QuantityLength(
                        1.0,
                        LengthUnit.FEET)

                        .add(

                                new QuantityLength(
                                        12.0,
                                        LengthUnit.INCHES),

                                LengthUnit.FEET);

        assertEquals(

                new QuantityLength(
                        2.0,
                        LengthUnit.FEET),

                result);
    }

    @Test
    void testQuantityLengthRefactored_AddWithTargetUnit() {

        QuantityLength result =

                new QuantityLength(
                        1.0,
                        LengthUnit.FEET)

                        .add(

                                new QuantityLength(
                                        12.0,
                                        LengthUnit.INCHES),

                                LengthUnit.YARDS);

        assertEquals(

                new QuantityLength(
                        0.666,
                        LengthUnit.YARDS),

                result);
    }

    @Test
    void testQuantityLengthRefactored_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new QuantityLength(
                        1.0,
                        null));
    }

    @Test
    void testQuantityLengthRefactored_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,

                () -> new QuantityLength(
                        Double.NaN,
                        LengthUnit.FEET));
    }

    @Test
    void testRoundTripConversion_RefactoredDesign() {

        QuantityLength original =
                new QuantityLength(
                        5.0,
                        LengthUnit.FEET);

        QuantityLength converted =
                original.convertTo(
                        LengthUnit.INCHES);

        QuantityLength back =
                converted.convertTo(
                        LengthUnit.FEET);

        assertEquals(original, back);
    }

    @Test
    void testUnitImmutability() {

        assertNotNull(LengthUnit.FEET);
    }
}