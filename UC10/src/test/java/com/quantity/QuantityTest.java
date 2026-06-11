package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void testLengthEquality() {

        Quantity<LengthUnit> foot =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12, LengthUnit.INCHES);

        assertEquals(foot, inches);
    }

    @Test
    void testWeightEquality() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testLengthConversion() {

        Quantity<LengthUnit> foot =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                foot.convertTo(LengthUnit.INCHES);

        assertEquals(12.0,
                result.getValue());
    }

    @Test
    void testWeightConversion() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0,
                result.getValue());
    }

    @Test
    void testAddition() {

        Quantity<LengthUnit> foot =
                new Quantity<>(1, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12, LengthUnit.INCHES);

        Quantity<LengthUnit> result =
                foot.add(inches,
                        LengthUnit.FEET);

        assertEquals(2.0,
                result.getValue());
    }
}
