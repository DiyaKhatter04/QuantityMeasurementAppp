package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        QuantityLength l1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength l2 =
                new QuantityLength(
                        2.0,
                        LengthUnit.FEET);

        QuantityLength result = l1.add(l2);

        assertEquals(
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

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

        assertEquals(
                new QuantityLength(
                        2.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_CrossUnit_InchesPlusFeet() {

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCHES);

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        QuantityLength result =
                inches.add(feet);

        assertEquals(
                new QuantityLength(
                        24.0,
                        LengthUnit.INCHES),
                result);
    }

    @Test
    void testAddition_YardsPlusFeet() {

        QuantityLength yards =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS);

        QuantityLength feet =
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET);

        QuantityLength result =
                yards.add(feet);

        assertEquals(
                new QuantityLength(
                        2.0,
                        LengthUnit.YARDS),
                result);
    }

    @Test
    void testAddition_WithZero() {

        QuantityLength feet =
                new QuantityLength(
                        5.0,
                        LengthUnit.FEET);

        QuantityLength zero =
                new QuantityLength(
                        0.0,
                        LengthUnit.INCHES);

        assertEquals(
                feet,
                feet.add(zero));
    }

    @Test
    void testAddition_NegativeValues() {

        QuantityLength l1 =
                new QuantityLength(
                        5.0,
                        LengthUnit.FEET);

        QuantityLength l2 =
                new QuantityLength(
                        -2.0,
                        LengthUnit.FEET);

        QuantityLength result =
                l1.add(l2);

        assertEquals(
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET),
                result);
    }

    @Test
    void testAddition_NullSecondOperand() {

        QuantityLength l1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> l1.add(null));
    }
}