package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityTest {

    @Test
    void shouldCompareEqualLengths() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES
                );

        assertEquals(
                feet,
                inches
        );
    }

    @Test
    void shouldCompareEqualWeights() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertEquals(
                kilogram,
                gram
        );
    }

    @Test
    void shouldCompareEqualVolumes() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> millilitre =
                new Quantity<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertEquals(
                litre,
                millilitre
        );
    }

    @Test
    void shouldConvertFeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> result =
                feet.convertTo(
                        LengthUnit.INCHES
                );

        assertEquals(
                12.0,
                result.getValue()
        );
    }

    @Test
    void shouldConvertKilogramToGram() {

        Quantity<WeightUnit> kilogram =
                new Quantity<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        Quantity<WeightUnit> result =
                kilogram.convertTo(
                        WeightUnit.GRAM
                );

        assertEquals(
                1000.0,
                result.getValue()
        );
    }

    @Test
    void shouldConvertLitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        Quantity<VolumeUnit> result =
                litre.convertTo(
                        VolumeUnit.MILLILITRE
                );

        assertEquals(
                1000.0,
                result.getValue()
        );
    }

    @Test
    void shouldAddLengths() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES
                );

        Quantity<LengthUnit> result =
                feet.add(
                        inches,
                        LengthUnit.FEET
                );

        assertEquals(
                2.0,
                result.getValue()
        );
    }

    @Test
    void shouldSubtractLengths() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> inches =
                new Quantity<>(
                        12.0,
                        LengthUnit.INCHES
                );

        Quantity<LengthUnit> result =
                feet.subtract(
                        inches,
                        LengthUnit.FEET
                );

        assertEquals(
                1.0,
                result.getValue()
        );
    }

    @Test
    void shouldDivideLengths() {

        Quantity<LengthUnit> feet1 =
                new Quantity<>(
                        2.0,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> feet2 =
                new Quantity<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertEquals(
                2.0,
                feet1.divide(feet2)
        );
    }

    @Test
    void shouldThrowExceptionForNullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(
                        10,
                        null
                )
        );
    }

    @Test
    void shouldThrowExceptionForNullTargetUnit() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1,
                        LengthUnit.FEET
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.convertTo(null)
        );
    }

    @Test
    void shouldThrowExceptionForDivisionByZero() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1,
                        LengthUnit.FEET
                );

        Quantity<LengthUnit> zero =
                new Quantity<>(
                        0,
                        LengthUnit.FEET
                );

        assertThrows(
                ArithmeticException.class,
                () -> feet.divide(zero)
        );
    }

    @Test
    void shouldCompareCelsiusAndFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32,
                        TemperatureUnit.FAHRENHEIT
                );

        assertEquals(
                celsius,
                fahrenheit
        );
    }

    @Test
    void shouldCompareCelsiusAndKelvin() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        assertEquals(
                celsius,
                kelvin
        );
    }

    @Test
    void shouldConvertTemperature() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        100,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> result =
                celsius.convertTo(
                        TemperatureUnit.FAHRENHEIT
                );

        assertEquals(
                212.0,
                result.getValue(),
                0.01
        );
    }

    @Test
    void shouldThrowExceptionWhenAddingTemperature() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.add(t2)
        );
    }

    @Test
    void shouldThrowExceptionWhenSubtractingTemperature() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.subtract(t2)
        );
    }

    @Test
    void shouldThrowExceptionWhenDividingTemperature() {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(
                        100,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(
                        50,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> t1.divide(t2)
        );
    }
}