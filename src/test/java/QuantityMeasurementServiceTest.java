
import com.quantity.enums.LengthUnit;
import com.quantity.enums.TemperatureUnit;
import com.quantity.enums.VolumeUnit;
import com.quantity.enums.WeightUnit;
import com.quantity.model.QuantityDTO;
import com.quantity.services.IQuantityMeasurementService;
import com.quantity.services.QuantityMeasurementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementServiceTest {

    private IQuantityMeasurementService service;

    @BeforeEach
    void setUp() {

        service = new QuantityMeasurementServiceImpl();
    }

    @Test
    void shouldCompareEqualLengths() {

        QuantityDTO<LengthUnit> feet =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> inches =
                new QuantityDTO<>(
                        12.0,
                        LengthUnit.INCHES
                );

        assertTrue(
                service.compare(
                        feet,
                        inches
                )
        );
    }

    @Test
    void shouldCompareEqualWeights() {

        QuantityDTO<WeightUnit> kilogram =
                new QuantityDTO<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        QuantityDTO<WeightUnit> gram =
                new QuantityDTO<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        assertTrue(
                service.compare(
                        kilogram,
                        gram
                )
        );
    }

    @Test
    void shouldCompareEqualVolumes() {

        QuantityDTO<VolumeUnit> litre =
                new QuantityDTO<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        QuantityDTO<VolumeUnit> ml =
                new QuantityDTO<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        assertTrue(
                service.compare(
                        litre,
                        ml
                )
        );
    }

    @Test
    void shouldConvertFeetToInches() {

        QuantityDTO<LengthUnit> feet =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> result =
                service.convert(
                        feet,
                        LengthUnit.INCHES
                );

        assertEquals(
                12.0,
                result.getValue()
        );
    }

    @Test
    void shouldConvertKilogramToGram() {

        QuantityDTO<WeightUnit> kilogram =
                new QuantityDTO<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        QuantityDTO<WeightUnit> result =
                service.convert(
                        kilogram,
                        WeightUnit.GRAM
                );

        assertEquals(
                1000.0,
                result.getValue()
        );
    }

    @Test
    void shouldConvertLitreToMillilitre() {

        QuantityDTO<VolumeUnit> litre =
                new QuantityDTO<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        QuantityDTO<VolumeUnit> result =
                service.convert(
                        litre,
                        VolumeUnit.MILLILITRE
                );

        assertEquals(
                1000.0,
                result.getValue()
        );
    }

    @Test
    void shouldAddLengths() {

        QuantityDTO<LengthUnit> feet =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> inches =
                new QuantityDTO<>(
                        12.0,
                        LengthUnit.INCHES
                );

        QuantityDTO<LengthUnit> result =
                service.add(
                        feet,
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

        QuantityDTO<LengthUnit> feet =
                new QuantityDTO<>(
                        2.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> inches =
                new QuantityDTO<>(
                        12.0,
                        LengthUnit.INCHES
                );

        QuantityDTO<LengthUnit> result =
                service.subtract(
                        feet,
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

        QuantityDTO<LengthUnit> feet1 =
                new QuantityDTO<>(
                        2.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> feet2 =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertEquals(
                2.0,
                service.divide(
                        feet1,
                        feet2
                )
        );
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
    void shouldConvertTemperature() {

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


    @Test
    void shouldThrowExceptionForNullTargetUnit() {

        QuantityDTO<LengthUnit> feet =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.convert(
                        feet,
                        null
                )
        );
    }

    @Test
    void shouldThrowExceptionForDivisionByZero() {

        QuantityDTO<LengthUnit> feet =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> zero =
                new QuantityDTO<>(
                        0.0,
                        LengthUnit.FEET
                );

        assertThrows(
                ArithmeticException.class,
                () -> service.divide(
                        feet,
                        zero
                )
        );
    }
}
