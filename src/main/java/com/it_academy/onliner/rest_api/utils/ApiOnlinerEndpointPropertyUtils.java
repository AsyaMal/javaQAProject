package com.it_academy.onliner.rest_api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiOnlinerEndpointPropertyUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(ApiOnlinerEndpointPropertyUtils.class);

    private static final Properties PROPERTIES = new Properties();
    private static final String PROPERTY_PATH = "src/main/resources/api.onliner.endpoints.properties";


    private static void getFile() {
        try (FileInputStream file = new FileInputStream(ApiOnlinerEndpointPropertyUtils.PROPERTY_PATH)) {
            PROPERTIES.load(file);
        } catch (IOException e) {
            LOG.error("file 'api.onliner.endpoints.properties' doesn't found");
        }
    }

    public static String getElectroBikeProduct() {
        getFile();
        return PROPERTIES.getProperty("endpoint.electrobike.products");
    }

    public static String getElectroBikeProductFilter() {
        getFile();
        return PROPERTIES.getProperty("endpoint.electrobike.filter");
    }
}