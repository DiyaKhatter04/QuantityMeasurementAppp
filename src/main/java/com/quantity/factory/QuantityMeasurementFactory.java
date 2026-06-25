package com.quantity.factory;


import com.quantity.controllers.QuantityMeasurementController;
import com.quantity.repository.IQuantityMeasurementRepository;
import com.quantity.repository.QuantityMeasurementCacheRepository;
import com.quantity.services.IQuantityMeasurementService;
import com.quantity.services.QuantityMeasurementServiceImpl;

public class QuantityMeasurementFactory {

    private static final IQuantityMeasurementRepository
            REPOSITORY =
            new QuantityMeasurementCacheRepository();

    private static final IQuantityMeasurementService
            SERVICE =
            new QuantityMeasurementServiceImpl();

    private static final QuantityMeasurementController
            CONTROLLER =
            new QuantityMeasurementController();

    private QuantityMeasurementFactory() {
    }

    public static IQuantityMeasurementRepository
    getRepository() {

        return REPOSITORY;
    }

    public static IQuantityMeasurementService
    getService() {

        return SERVICE;
    }

    public static QuantityMeasurementController
    getController() {

        return CONTROLLER;
    }
}