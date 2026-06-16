package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    void testLengthEquality() {

        Quantity<LengthUnit> length1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> length2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    void testWeightEquality() {

        Quantity<WeightUnit> weight1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weight2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    void testVolumeEquality() {

        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(volume1, volume2);
    }

    @Test
    void testLengthConversion() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                length.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(12.0, LengthUnit.INCHES),
                result
        );
    }

    @Test
    void testWeightConversion() {

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                weight.convertTo(WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(1000.0, WeightUnit.GRAM),
                result
        );
    }

    @Test
    void testVolumeConversion() {

        Quantity<VolumeUnit> volume =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                volume.convertTo(
                        VolumeUnit.MILLILITRE
                );

        assertEquals(
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                ),
                result
        );
    }

    @Test
    void testAdditionLength() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.add(q2, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(2.0, LengthUnit.FEET),
                result
        );
    }

    @Test
    void testAdditionWeight() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                q1.add(q2, WeightUnit.KILOGRAM);

        assertEquals(
                new Quantity<>(
                        2.0,
                        WeightUnit.KILOGRAM
                ),
                result
        );
    }

    @Test
    void testAdditionVolume() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> result =
                q1.add(q2, VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(2.0, VolumeUnit.LITRE),
                result
        );
    }

    @Test
    void testSubtractionLength() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                q1.subtract(q2, LengthUnit.FEET);

        assertEquals(
                new Quantity<>(1.0, LengthUnit.FEET),
                result
        );
    }

    @Test
    void testSubtractionWeight() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                q1.subtract(q2, WeightUnit.KILOGRAM);

        assertEquals(
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                ),
                result
        );
    }

    @Test
    void testSubtractionVolume() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        Quantity<VolumeUnit> result =
                q1.subtract(q2, VolumeUnit.LITRE);

        assertEquals(
                new Quantity<>(1.0, VolumeUnit.LITRE),
                result
        );
    }

    @Test
    void testDivisionLength() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(24.0, LengthUnit.INCHES);

        Quantity<LengthUnit> q2 =
                new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(
                1.0,
                q1.divide(q2),
                0.0001
        );
    }

    @Test
    void testDivisionWeight() {

        Quantity<WeightUnit> q1 =
                new Quantity<>(2.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> q2 =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(
                2.0,
                q1.divide(q2),
                0.0001
        );
    }

    @Test
    void testDivisionVolume() {

        Quantity<VolumeUnit> q1 =
                new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> q2 =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertEquals(
                2.0,
                q1.divide(q2),
                0.0001
        );
    }

    @Test
    void testNullUnitThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(10, null)
        );
    }

    @Test
    void testNullQuantityAddition() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.add(null)
        );
    }

    @Test
    void testNullQuantitySubtraction() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> q1.subtract(null)
        );
    }

    @Test
    void testDivisionByZero() {

        Quantity<LengthUnit> q1 =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> q2 =
                new Quantity<>(0.0, LengthUnit.INCHES);

        assertThrows(
                ArithmeticException.class,
                () -> q1.divide(q2)
        );
    }

    @Test
    void testArithmeticOperationAdd() {

        assertEquals(
                15.0,
                ArithmeticOperation.ADD.compute(
                        10.0,
                        5.0
                ),
                0.0001
        );
    }

    @Test
    void testArithmeticOperationSubtract() {

        assertEquals(
                5.0,
                ArithmeticOperation.SUBTRACT.compute(
                        10.0,
                        5.0
                ),
                0.0001
        );
    }

    @Test
    void testArithmeticOperationDivide() {

        assertEquals(
                2.0,
                ArithmeticOperation.DIVIDE.compute(
                        10.0,
                        5.0
                ),
                0.0001
        );
    }

    @Test
    void testArithmeticOperationDivideByZero() {

        assertThrows(
                ArithmeticException.class,
                () -> ArithmeticOperation.DIVIDE.compute(
                        10.0,
                        0.0
                )
        );
    }
}