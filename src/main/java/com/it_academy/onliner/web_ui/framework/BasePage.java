package com.it_academy.onliner.web_ui.framework;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage() {
        Configuration.browser = SelenideWebDriverDiscovery.class.getName();
        Configuration.pageLoadTimeout = 200000;
        Configuration.browserSize = "1600x900";
    }

    public void navigate(String url) {
        open(url);
    }
}