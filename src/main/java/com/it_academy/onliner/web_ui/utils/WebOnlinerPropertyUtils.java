package com.it_academy.onliner.web_ui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebOnlinerPropertyUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(WebOnlinerPropertyUtils.class);

    private static final Properties PROPERTIES = new Properties();
    private static final String PROPERTIES_PATH = "src/main/resources/web.ui.onliner.properties";


    private static void getFile() {
        try (FileInputStream file = new FileInputStream(WebOnlinerPropertyUtils.PROPERTIES_PATH)) {
            PROPERTIES.load(file);
        } catch (IOException e) {
            LOG.error("file 'web.ui.onliner.properties' doesn't found");
        }
    }

    public static String getOnlinerHomePageURL() {
        getFile();
        return PROPERTIES.getProperty("onliner.homepage.url");
    }
}

