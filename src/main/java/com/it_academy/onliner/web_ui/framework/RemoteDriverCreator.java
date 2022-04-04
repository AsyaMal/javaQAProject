package com.it_academy.onliner.web_ui.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverCreator implements WebDriverCreator<RemoteWebDriver> {

    protected static final Logger LOG = LoggerFactory.getLogger(RemoteDriverCreator.class);
    private static final String BROWSER = "MicrosoftEdge";

    @Override
    public RemoteWebDriver create() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BROWSER);
        capabilities.setPlatform(Platform.WIN10);
        return new RemoteWebDriver(getGridUrl(), capabilities);
    }

    private URL getGridUrl() {

        try {
            return new URL(System.getProperty("webdriver.remote.driver"));
        } catch (MalformedURLException e) {
            LOG.error("URL doesn't create");
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
