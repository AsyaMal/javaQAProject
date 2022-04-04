package com.it_academy.tests.onliner.web_ui_test;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.onliner.web_ui.navigation.OnlinerNavigation;
import com.it_academy.tests.onliner.listeners.AllureListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith({AllureListener.class})
public class BaseWebTest {

    protected static final Logger LOG = LoggerFactory.getLogger(BaseWebTest.class);

    @BeforeAll
    public static void setUp() {
        SelenideLogger
                .addListener("AllureSelenide",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeAll
    public static void navigateToOnliner() {
        OnlinerNavigation.navigateToOnlinerHomePage();
        LOG.info("Onliner is opened");
    }


}
