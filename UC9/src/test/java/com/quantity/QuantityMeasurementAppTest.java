package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_KilogramToKilogram_SameValue() {

        assertEquals(

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM),

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM));
    }

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {

        assertEquals(

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM),

                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM));
    }

    @Test
    void testEquality_GramToKilogram_EquivalentValue() {

        assertEquals(

                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM),

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM));
    }

    @Test
    void testEquality_NullComparison() {

        QuantityWeight weight =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertNotEquals(null, weight);
    }

    @Test
    void testEquality_SameReference() {

        QuantityWeight weight =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        assertTrue(weight.equals(weight));
    }

    @Test
    void testConversion_PoundToKilogram() {

        QuantityWeight pound =
                new QuantityWeight(
                        2.20462,
                        WeightUnit.POUND);

        QuantityWeight result =
                pound.convertTo(
                        WeightUnit.KILOGRAM);

        assertEquals(

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM),

                result);
    }

    @Test
    void testConversion_KilogramToPound() {

        QuantityWeight kilogram =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight result =
                kilogram.convertTo(
                        WeightUnit.POUND);

        assertEquals(

                new QuantityWeight(
                        2.20462,
                        WeightUnit.POUND),

                result);
    }

    @Test
    void testConversion_SameUnit() {

        QuantityWeight kilogram =
                new QuantityWeight(
                        5.0,
                        WeightUnit.KILOGRAM);

        assertEquals(
                kilogram,
                kilogram.convertTo(
                        WeightUnit.KILOGRAM));
    }

    @Test
    void testAddition_SameUnit_KilogramPlusKilogram() {

        QuantityWeight result =

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM)

                        .add(

                                new QuantityWeight(
                                        2.0,
                                        WeightUnit.KILOGRAM));

        assertEquals(

                new QuantityWeight(
                        3.0,
                        WeightUnit.KILOGRAM),

                result);
    }

    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {

        QuantityWeight result =

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM)

                        .add(

                                new QuantityWeight(
                                        1000.0,
                                        WeightUnit.GRAM));

        assertEquals(

                new QuantityWeight(
                        2.0,
                        WeightUnit.KILOGRAM),

                result);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Kilogram() {

        QuantityWeight result =

                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM)

                        .add(

                                new QuantityWeight(
                                        1000.0,
                                        WeightUnit.GRAM),

                                WeightUnit.GRAM);

        assertEquals(

                new QuantityWeight(
                        2000.0,
                        WeightUnit.GRAM),

                result);
    }

    @Test
    void testAddition_WithZero() {

        QuantityWeight result =

                new QuantityWeight(
                        5.0,
                        WeightUnit.KILOGRAM)

                        .add(

                                new QuantityWeight(
                                        0.0,
                                        WeightUnit.GRAM));

        assertEquals(

                new QuantityWeight(
                        5.0,
                        WeightUnit.KILOGRAM),

                result);
    }

    @Test
    void testAddition_NegativeValues() {

        QuantityWeight result =

                new QuantityWeight(
                        5.0,
                        WeightUnit.KILOGRAM)

                        .add(

                                new QuantityWeight(
                                        -2000.0,
                                        WeightUnit.GRAM));

        assertEquals(

                new QuantityWeight(
                        3.0,
                        WeightUnit.KILOGRAM),

                result);
    }

    @Test
    void testAddition_LargeValues() {

        QuantityWeight result =

                new QuantityWeight(
                        1000000.0,
                        WeightUnit.KILOGRAM)

                        .add(

                                new QuantityWeight(
                                        1000000.0,
                                        WeightUnit.KILOGRAM));

        assertEquals(

                new QuantityWeight(
                        2000000.0,
                        WeightUnit.KILOGRAM),

                result);
    }

    @Test
    void testWeightVsLength_Incompatible() {

        QuantityWeight weight =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityLength length =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET);

        assertFalse(weight.equals(length));
    }
}