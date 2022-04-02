package com.it_academy.onliner.rest_api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EndpointPropertyUtils {
    private static Properties property = new Properties();
    private static final String endpoint = "src/main/resources/endpoints.properties";

    private static void getFile() {
        try (FileInputStream file = new FileInputStream(EndpointPropertyUtils.endpoint)) {
            property.load(file);
        } catch (IOException e) {
            System.out.println("file '.properties' doesn't found");
        }
    }

    public static String getElectroBikeProduct() {
        getFile();
        return property.getProperty("endpoint.electrobike.products");
    }

    public static String getElectroBikeProductFilter() {
        getFile();
        return property.getProperty("endpoint.electrobike.filter");
    }
}