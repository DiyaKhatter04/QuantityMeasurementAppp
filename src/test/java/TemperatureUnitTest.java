

import com.quantity.enums.TemperatureUnit;
import com.quantity.model.QuantityDTO;
import com.quantity.services.IQuantityMeasurementService;
import com.quantity.services.QuantityMeasurementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureUnitTest {

    private IQuantityMeasurementService service;

    @BeforeEach
    void setUp() {

        service = new QuantityMeasurementServiceImpl();
    }

    @Test
    void shouldCompareCelsiusAndFahrenheit() {

        QuantityDTO<TemperatureUnit> celsius =
                new QuantityDTO<>(
                        0.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> fahrenheit =
                new QuantityDTO<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT
                );

        assertTrue(
                service.compare(
                        celsius,
                        fahrenheit
                )
        );
    }

    @Test
    void shouldCompareCelsiusAndKelvin() {

        QuantityDTO<TemperatureUnit> celsius =
                new QuantityDTO<>(
                        0.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> kelvin =
                new QuantityDTO<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        assertTrue(
                service.compare(
                        celsius,
                        kelvin
                )
        );
    }

    @Test
    void shouldConvertCelsiusToFahrenheit() {

        QuantityDTO<TemperatureUnit> celsius =
                new QuantityDTO<>(
                        100.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> result =
                service.convert(
                        celsius,
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

        QuantityDTO<TemperatureUnit> kelvin =
                new QuantityDTO<>(
                        273.15,
                        TemperatureUnit.KELVIN
                );

        QuantityDTO<TemperatureUnit> result =
                service.convert(
                        kelvin,
                        TemperatureUnit.CELSIUS
                );

        assertEquals(
                0.0,
                result.getValue(),
                0.01
        );
    }

    @Test
    void shouldThrowExceptionWhenAddingTemperature() {

        QuantityDTO<TemperatureUnit> t1 =
                new QuantityDTO<>(
                        100.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> t2 =
                new QuantityDTO<>(
                        50.0,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> service.add(
                        t1,
                        t2,
                        TemperatureUnit.CELSIUS
                )
        );
    }

    @Test
    void shouldThrowExceptionWhenSubtractingTemperature() {

        QuantityDTO<TemperatureUnit> t1 =
                new QuantityDTO<>(
                        100.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> t2 =
                new QuantityDTO<>(
                        50.0,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> service.subtract(
                        t1,
                        t2,
                        TemperatureUnit.CELSIUS
                )
        );
    }

    @Test
    void shouldThrowExceptionWhenDividingTemperature() {

        QuantityDTO<TemperatureUnit> t1 =
                new QuantityDTO<>(
                        100.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> t2 =
                new QuantityDTO<>(
                        50.0,
                        TemperatureUnit.CELSIUS
                );

        assertThrows(
                UnsupportedOperationException.class,
                () -> service.divide(
                        t1,
                        t2
                )
        );
    }
}
