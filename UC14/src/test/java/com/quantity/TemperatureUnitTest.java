package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureUnitTest {

    @Test
    void shouldCompareCelsiusAndFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        0.0,
                        TemperatureUnit.CELSIUS
                );

        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(
                        32.0,
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
                        0.0,
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
    void shouldConvertCelsiusToFahrenheit() {

        Quantity<TemperatureUnit> celsius =
                new Quantity<>(
                        100.0,
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
    void shouldConvertKelvinToCelsius() {

        Quantity<TemperatureUnit> kelvin =
                new Quantity<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        Quantity<TemperatureUnit> result =
                kelvin.convertTo(
                        TemperatureUnit.CELSIUS
                );

        assertEquals(
                0.0,
                result.getValue(),
                0.01
        );
    }

    @Test
    void shouldThrowExceptionForAdd() {

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
    void shouldThrowExceptionForSubtract() {

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
    void shouldThrowExceptionForDivide() {

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