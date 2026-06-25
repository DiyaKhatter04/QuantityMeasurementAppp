package com.quantity.app;

import com.quantity.controllers.QuantityMeasurementController;
import com.quantity.enums.LengthUnit;
import com.quantity.enums.TemperatureUnit;
import com.quantity.enums.VolumeUnit;
import com.quantity.enums.WeightUnit;
import com.quantity.factory.QuantityMeasurementFactory;
import com.quantity.model.QuantityDTO;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementController controller =
                QuantityMeasurementFactory.getController();

        QuantityDTO<LengthUnit> length1 =
                new QuantityDTO<>(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityDTO<LengthUnit> length2 =
                new QuantityDTO<>(
                        12.0,
                        LengthUnit.INCHES
                );

        QuantityDTO<WeightUnit> weight1 =
                new QuantityDTO<>(
                        1.0,
                        WeightUnit.KILOGRAM
                );

        QuantityDTO<WeightUnit> weight2 =
                new QuantityDTO<>(
                        1000.0,
                        WeightUnit.GRAM
                );

        QuantityDTO<VolumeUnit> volume1 =
                new QuantityDTO<>(
                        1.0,
                        VolumeUnit.LITRE
                );

        QuantityDTO<VolumeUnit> volume2 =
                new QuantityDTO<>(
                        1000.0,
                        VolumeUnit.MILLILITRE
                );

        QuantityDTO<TemperatureUnit> temp1 =
                new QuantityDTO<>(
                        0.0,
                        TemperatureUnit.CELSIUS
                );

        QuantityDTO<TemperatureUnit> temp2 =
                new QuantityDTO<>(
                        32.0,
                        TemperatureUnit.FAHRENHEIT
                );

        System.out.println(
                "===== LENGTH ====="
        );

        System.out.println(
                "Compare : " +
                        controller.compare(
                                length1,
                                length2
                        )
        );

        System.out.println(
                "Convert : " +
                        controller.convert(
                                length1,
                                LengthUnit.INCHES
                        ).getValue()
                        + " Inches"
        );

        System.out.println(
                "Add : " +
                        controller.add(
                                length1,
                                length2,
                                LengthUnit.FEET
                        ).getValue()
                        + " Feet"
        );

        System.out.println(
                "Subtract : " +
                        controller.subtract(
                                length1,
                                length2,
                                LengthUnit.FEET
                        ).getValue()
                        + " Feet"
        );

        System.out.println(
                "Divide : " +
                        controller.divide(
                                length1,
                                length2
                        )
        );

        System.out.println(
                "\n===== WEIGHT ====="
        );

        System.out.println(
                "Compare : " +
                        controller.compare(
                                weight1,
                                weight2
                        )
        );

        System.out.println(
                "Convert : " +
                        controller.convert(
                                weight1,
                                WeightUnit.GRAM
                        ).getValue()
                        + " Gram"
        );

        System.out.println(
                "Add : " +
                        controller.add(
                                weight1,
                                weight2,
                                WeightUnit.KILOGRAM
                        ).getValue()
                        + " Kg"
        );

        System.out.println(
                "Subtract : " +
                        controller.subtract(
                                weight1,
                                weight2,
                                WeightUnit.KILOGRAM
                        ).getValue()
                        + " Kg"
        );

        System.out.println(
                "Divide : " +
                        controller.divide(
                                weight1,
                                weight2
                        )
        );

        System.out.println(
                "\n===== VOLUME ====="
        );

        System.out.println(
                "Compare : " +
                        controller.compare(
                                volume1,
                                volume2
                        )
        );

        System.out.println(
                "Convert : " +
                        controller.convert(
                                volume1,
                                VolumeUnit.MILLILITRE
                        ).getValue()
                        + " ml"
        );

        System.out.println(
                "Add : " +
                        controller.add(
                                volume1,
                                volume2,
                                VolumeUnit.LITRE
                        ).getValue()
                        + " Litre"
        );

        System.out.println(
                "Subtract : " +
                        controller.subtract(
                                volume1,
                                volume2,
                                VolumeUnit.LITRE
                        ).getValue()
                        + " Litre"
        );

        System.out.println(
                "Divide : " +
                        controller.divide(
                                volume1,
                                volume2
                        )
        );

        System.out.println(
                "\n===== TEMPERATURE ====="
        );

        System.out.println(
                "Compare : " +
                        controller.compare(
                                temp1,
                                temp2
                        )
        );

        System.out.println(
                "Convert : " +
                        controller.convert(
                                temp1,
                                TemperatureUnit.FAHRENHEIT
                        ).getValue()
                        + " Fahrenheit"
        );

        try {

            controller.add(
                    temp1,
                    temp2,
                    TemperatureUnit.CELSIUS
            );

        } catch (
                UnsupportedOperationException e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }

        try {

            controller.divide(
                    temp1,
                    temp2
            );

        } catch (
                UnsupportedOperationException e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }
}