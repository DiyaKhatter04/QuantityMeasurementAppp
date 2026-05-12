package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(
                QuantityMeasurementApp.areFeetEqual(1.0, 1.0)
        );
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(
                QuantityMeasurementApp.areFeetEqual(1.0, 2.0)
        );
    }

    @Test
    void testInchEquality_SameValue() {
        assertTrue(
                QuantityMeasurementApp.areInchesEqual(1.0, 1.0)
        );
    }

    @Test
    void testInchEquality_DifferentValue() {
        assertFalse(
                QuantityMeasurementApp.areInchesEqual(1.0, 2.0)
        );
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null));
    }

    @Test
    void testInchEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch =
                new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inch.equals(null));
    }
}